package com.epatient.backend.security;

public class SecurityConstants {
    public static final String SECRET = System.getenv("secret") == null ? "d3Rm" : System.getenv("secret"); // d3Rm for tests
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final long EXPIRATION_TIME = 864000000L;
}
