package com.iceman.simplespring.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "emp")
public class Employer {
    @Id
    String tabno;
    String name;
    String post;
    double salary;
    LocalDate born;
    String phone;
    @ManyToOne(cascade =  {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JsonBackReference
    @JoinColumn(name = "depno")
    Department department;
    @OneToMany(mappedBy = "parent")
    @JsonManagedReference
    List<Child> children;


    public Employer(String tabno, String name, String post, double salary, LocalDate born, String phone, Department department) {
        this.children = new ArrayList<>();
        this.tabno = tabno;
        this.name = name;
        this.post = post;
        this.salary = salary;
        this.born = born;
        this.phone = phone;
        this.department = department;
    }

    public Employer() {
        this.children = new ArrayList<>();
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getTabno() {
        return tabno;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public String getPost() {
        return post;
    }

    public LocalDate getBorn() {
        return born;
    }

    public String getPhone() {
        return phone;
    }

    public void setTabno(String tabno) {
        this.tabno = tabno;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setBorn(LocalDate born) {
        this.born = born;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public static String getTableName() {
        return "emp";
    }

    @Override
    public String toString() {
        return "Employer{" +
                "tabno='" + tabno + '\'' +
                ", name='" + name + '\'' +
                ", post='" + post + '\'' +
                ", salary=" + salary +
                ", born=" + born +
                ", phone='" + phone + '\'' +
                ", department=" + department.name +
                '}';
    }
}