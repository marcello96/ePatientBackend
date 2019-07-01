package com.epatient.backend.service;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@Component
public class SseEmitterFactory {

    private static final long DEFAULT_TIMEOUT = 600_000L;

    public SseEmitter create() {
        return new SseEmitter(DEFAULT_TIMEOUT);
    }
}
