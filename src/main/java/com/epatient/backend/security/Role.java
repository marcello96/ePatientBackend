package com.epatient.backend.security;

public enum Role {
    PATIENT,
    DOCTOR;

    public static String addRolePrefix(Role role) {
        return "ROLE_" + role.name();
    }
}
