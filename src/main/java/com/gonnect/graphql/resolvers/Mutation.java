package com.gonnect.graphql.resolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.gonnect.graphql.entities.MyPet;
import com.gonnect.graphql.enums.AvailablePets;
import com.gonnect.graphql.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mutation implements GraphQLMutationResolver {
    @Autowired
    private PetRepository petRepository;

    public MyPet createMyPet(Integer id, AvailablePets availablePets, String name, Integer age) {

        MyPet myPet = new MyPet();
        myPet.setId(id);
        myPet.setType(availablePets);
        myPet.setName(name);
        myPet.setAge(age);

        return petRepository.save(myPet);
    }
}