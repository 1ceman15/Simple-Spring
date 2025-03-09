package com.iceman.simplespring.entity;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ChildId implements Serializable {
    private String name;
    private String tabno;

    public ChildId(String name, String tabno) {
        this.name = name;
        this.tabno = tabno;
    }

    public ChildId() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTabno() {
        return tabno;
    }

    public void setTabno(String tabno) {
        this.tabno = tabno;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ChildId childPK = (ChildId) o;
        return Objects.equals(name, childPK.name) && Objects.equals(tabno, childPK.tabno);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, tabno);
    }

    @Override
    public String toString() {
        return "ChildPK{" +
                "name='" + name + '\'' +
                ", tabno=" + tabno +
                '}';
    }
}
