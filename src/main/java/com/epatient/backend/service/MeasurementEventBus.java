package com.epatient.backend.service;

import com.epatient.backend.model.dto.MeasurementDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import static com.epatient.backend.service.EventType.INIT;
import static com.epatient.backend.service.EventType.MEASUREMENT;
import static com.epatient.backend.service.UnsubscribeReason.COMPLETION;
import static com.epatient.backend.service.UnsubscribeReason.ERROR;
import static com.epatient.backend.service.UnsubscribeReason.TIMEOUT;

@Slf4j
@Component
public class MeasurementEventBus {

    private final SseEmitterFactory sseEmitterFactory;
    // Contains:          <PatientId, <EmitterId, Emitter>>
    private ConcurrentHashMap<Long, Map<String, SseEmitter>> subscriptions = new ConcurrentHashMap<>();

    public MeasurementEventBus(SseEmitterFactory sseEmitterFactory) {
        this.sseEmitterFactory = sseEmitterFactory;
    }

    public SseEmitter createSseEmitterForPatient(Long patientId) {
        SseEmitter emitter = sseEmitterFactory.create();
        String emitterId = UUID.randomUUID().toString();

        subscribeEmitter(patientId, emitterId, emitter);

        emitter.onCompletion(() -> unsubscribeEmitter(patientId, emitterId, COMPLETION));
        emitter.onTimeout(() -> unsubscribeEmitter(patientId, emitterId, TIMEOUT));
        emitter.onError(e -> unsubscribeEmitter(patientId, emitterId, ERROR));

        sendInitEvent(patientId, emitterId, emitter);
        return emitter;
    }

    public void sendMeasurementEvent(Long patientId, MeasurementDTO measurementDTO) {
        Map<String, SseEmitter> emitterToNotify = subscriptions.get(patientId);
        if (emitterToNotify == null) {
            return;
        }
        for(Map.Entry<String, SseEmitter> entry : emitterToNotify.entrySet()) {
            String emitterId = entry.getKey();
            SseEmitter emitter = entry.getValue();
            try {
                log.debug("Emitter {} for patient {} notified with {} event", emitterId, patientId, MEASUREMENT.name());
                emitter.send(
                        SseEmitter.event()
                                .name(MEASUREMENT.name())
                                .data(measurementDTO)
                );
            } catch (IOException e) {
                emitter.completeWithError(e);
            }
        }
    }

    private void sendInitEvent(Long patientId, String emitterId, SseEmitter emitter) {
        try {
            log.debug("Emitter {} for patient {} notified with {} event", emitterId, patientId, INIT.name());
            emitter.send(
                    SseEmitter.event()
                            .name(INIT.name())
                            .data("Emitter initiated.")
            );
        } catch (IOException e) {
            emitter.completeWithError(e);
        }
    }

    private void subscribeEmitter(Long patientId, String emitterId, SseEmitter emitter) {
        log.debug("Subscribing emitter {} for patientId = {}", emitterId, patientId);
        Map<String, SseEmitter> emittersForPatient =
                subscriptions.computeIfAbsent(patientId, _ignored -> new ConcurrentHashMap<>());
        emittersForPatient.put(emitterId, emitter);
    }

    private void unsubscribeEmitter(Long patientId, String emitterId, UnsubscribeReason reason) {
        Map<String, SseEmitter> emittersForPatient = subscriptions.get(patientId);
        if (emittersForPatient != null) {
            emittersForPatient.remove(emitterId);
            log.debug("Unsubscribed emitter {} for patient {} with reason = {}", emitterId, patientId, reason);
        }
    }
}
