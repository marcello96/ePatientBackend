package com.epatient.backend.controller;

class UrlRequest {

    static final String URL_HEART_RATE_GET_BY_MIBAND_ID  = "/heart_rate/id/{id}";

    static final String URL_HEART_RATE_GET_BY_MIBAND_ID_FOR_RECENT_PERIOD  =
            "/heart_rate/recent_period/{miband_id}/{start_date}";

    static final String FAIL_RETURN_VALUE = "false";
}
