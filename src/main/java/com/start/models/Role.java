package com.start.models;

import java.io.Serializable;

public enum Role implements Serializable {

    TEACHER("teacher"),
    STUDENT("student");
    private final String role;

    Role(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "Role{" +
                "role='" + role + '\'' +
                '}';
    }

}
