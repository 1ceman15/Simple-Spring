package com.iceman.simplespring.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDate;


@Entity(name = "children")
public class Child {
    @EmbeddedId
    ChildId id;

    char sex;
    LocalDate born;
    @ManyToOne(cascade =  {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name =  "tabno", insertable = false, updatable = false) // Внешний ключ на Employer
    @JsonBackReference
    Employer parent;

    public Child() {
    }

    public Child(String name, String tabno, char sex, LocalDate born, Employer parent) {
        this.id = new ChildId(tabno, name);
        this.sex = sex;
        this.born = born;
        this.parent = parent;
    }

    public Child(String name, String tabno, char sex, LocalDate born) {
        this.id = new ChildId(tabno, name);
        this.sex = sex;
        this.born = born;
    }

    public String getName() {
        return this.id.getName();
    }

    public void setName(String name) {
        this.id.setName(name);
    }

    public String getTabno() {
        return this.id.getTabno();
    }

    public void setTabno(String tabno) {
        this.id.setTabno(tabno);
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public LocalDate getBorn() {
        return born;
    }

    public void setBorn(LocalDate born) {
        this.born = born;
    }

    public Employer getParent() {
        return parent;
    }

    public void setParent(Employer parent) {
        this.parent = parent;
    }

    public static String getTableName() {
        return "children";
    }

    @Override
    public String toString() {
        return "Child{" +
                "name='" + this.id.getName() + '\'' +
                ", tabno=" + this.id.getTabno() +
                ", sex=" + sex +
                ", born=" + born +
                '}';
    }
}
