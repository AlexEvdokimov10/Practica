package com.practica.demo.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="departments")
public class Department {
    @Id
    private Long id;

    private String name;



    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Doctor> doctorSet;

    public Department() {
    }

    public Department(Set<Doctor> doctorSet) {
        this.doctorSet = doctorSet;
    }
    public Set<Doctor> getDoctorSet() {
        return doctorSet;
    }

    public void setDoctorSet(Set<Doctor> doctorSet) {
        this.doctorSet = doctorSet;
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
}
