package com.gonnect.graphql.resolvers;

import java.util.ArrayList;
import java.util.List;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.gonnect.graphql.entities.MyPet;
import com.gonnect.graphql.enums.AvailablePets;
import org.springframework.stereotype.Component;

@Component
public class Query implements GraphQLQueryResolver {

    public List<MyPet> pets() {
        List<MyPet> myPets = new ArrayList<>();
        MyPet aMyPet = new MyPet();
        aMyPet.setId(1l);
        aMyPet.setName("Bill");
        aMyPet.setAge(9);
        aMyPet.setType(AvailablePets.MAMMOTH);
        myPets.add(aMyPet);
        return myPets;
    }

    public List<MyPet> petsById(Integer id) {
        List<MyPet> myPets = new ArrayList<>();
        MyPet aMyPet = new MyPet();
        aMyPet.setId(id);
        aMyPet.setName("Thomas");
        aMyPet.setAge(9);
        aMyPet.setType(AvailablePets.MAMMOTH);
        myPets.add(aMyPet);
        return myPets;
    }


    public List<MyPet> petsByFilter(String filter) {
        List<MyPet> myPets = new ArrayList<>();
        MyPet aMyPet = new MyPet();
        aMyPet.setId(1);
        aMyPet.setName("Martin");
        aMyPet.setAge(9);
        aMyPet.setType(AvailablePets.MAMMOTH);
        myPets.add(aMyPet);
        return myPets;
    }
}