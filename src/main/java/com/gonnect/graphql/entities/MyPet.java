package com.gonnect.graphql.entities;

import com.gonnect.graphql.enums.AvailablePets;
import lombok.Data;

@Data
public class MyPet {
    private long id;

    private String name;

    private AvailablePets type;

    private int age;
}