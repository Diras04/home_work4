package com.start.models;

import java.util.Comparator;

public class Person extends SuperObject{
    private static int idstatik = 1;

    private Role role;
    private String lastname;
    private String phone;
    private String email;




    public Person(String firstname, String lastname, String phone, String email, Role role) {
        super(firstname, idstatik);
        this.lastname = lastname;
        this.phone = phone;
        this.email = email;
        this.id = idstatik;
        this.role = role;
        idstatik++;
    }

    public Role getRole() {
        return role;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public static Comparator<Person> personComparator = new Comparator<Person>() {

        public int compare(Person p1, Person p2) {
            String personName1 = p1.getLastname().toUpperCase();
            String personName2 = p2.getLastname().toUpperCase();


            return personName1.compareTo(personName2);


        }};

    @Override
    public String toString() {
        return "Person{" +
                "role=" + role +
                ", lastname='" + lastname + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
