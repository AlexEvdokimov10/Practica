package com.practica.demo.models;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "doctors")
public class Doctor implements Serializable {

    @Id
    private Long id;

    private String name;

    private String surname;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;
    public Doctor() {

    }

    public Doctor(String name, String surname, Department department){
        this.name=name;
        this.surname=surname;
        this.department = department;

    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

}
