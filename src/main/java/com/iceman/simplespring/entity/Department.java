package com.iceman.simplespring.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "depart")
public class Department {
    @Id
    @Column(name = "depno")
    private int id;
    private String name;
    @OneToMany(mappedBy = "department", fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Employer> employers;

    public Department() {
        this.employers = new ArrayList<>();
    }

    public Department(int id, String name) {
        this.id = id;
        this.name = name;
        this.employers = new ArrayList<>();
    }

    public List<Employer> getEmployers() {
        return employers;
    }

    public void setEmployers(List<Employer> employers) {
        this.employers = employers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static String getTableName() {
        return "depart";
    }
    @Override
    public String toString() {
        return "Depart{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", employers=" + employers +
                '}';
    }
}
