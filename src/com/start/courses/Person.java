package com.start.courses;

public class Person extends SuperObject{
    private static int idstatik = 1;

    private Role role;


    public Person(String inname, Role role) {
        super(inname, idstatik);
        this.id = idstatik;
        this.role = role;
        idstatik++;
    }

    public Role getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "Person{" +
                "role=" + role +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
