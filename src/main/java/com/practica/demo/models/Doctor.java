package com.practica.demo.models;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "doctors")
public class Doctor implements Serializable {

    @Id
    private Long id;

    private String name;

    private String surname;

    private String experience;

    private Date invitation;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;
    public Doctor() {

    }

    public Doctor(String name, String surname,String experience,Date invitation, Department department){
        this.name=name;
        this.surname=surname;
        this.invitation=invitation;
        this.department = department;
        this.experience=experience;

    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Date getInvitation() {
        return invitation;
    }
    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public void setInvitation(Date invitation) {
        this.invitation = invitation;
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
