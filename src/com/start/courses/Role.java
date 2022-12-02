package com.start.courses;

public enum Role {
<<<<<<< HEAD
=======
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
>>>>>>> task12
}
