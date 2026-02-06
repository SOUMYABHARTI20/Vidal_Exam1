package com.cdac;

import jakarta.persistence.*;


@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int regNo;

    private String name;

    @Column(unique = true)
    private String email;

    public Student() {}

    public int getregNo() {
        return regNo;
    }

    public void setregNo(int regNo) {
        this.regNo = regNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
 
}
