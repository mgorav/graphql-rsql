package com.gonnect.graphql.entities;

import com.gonnect.graphql.enums.AvailablePets;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MyPet {
    @Id
    private Integer id;

    private String name;

    private AvailablePets type;

    private int age;

    public MyPet() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AvailablePets getType() {
        return type;
    }

    public void setType(AvailablePets type) {
        this.type = type;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}