package com.gonnect.graphql.resolvers;

import java.util.*;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.gonnect.graphql.entities.MyPet;
import com.gonnect.graphql.enums.AvailablePets;
import com.gonnect.graphql.repository.PetRepository;
import com.gonnect.graphql.rsql.PetRsqlVisitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import static java.util.Arrays.asList;
import static java.util.Collections.EMPTY_LIST;

import cz.jirutka.rsql.parser.RSQLParser;
import cz.jirutka.rsql.parser.ast.Node;

@Component
public class Query implements GraphQLQueryResolver {
    @Autowired
    private PetRepository petRepository;

    public List<MyPet> pets() {

        return petRepository.findAll();
    }

    public List<MyPet> petsById(Integer id) {
        Optional<MyPet> optionalMyPet = petRepository.findById(id.toString());

        return optionalMyPet.isPresent() ? asList(optionalMyPet.get()) : EMPTY_LIST;
    }


    public List<MyPet> petsByFilter(String filter) {

        Node rootNode = new RSQLParser().parse(filter);
        Specification<MyPet> spec = rootNode.accept(new PetRsqlVisitor<>());

        return petRepository.findAll(spec);
    }

    public MyPet createMyPet(Integer id, AvailablePets availablePets, String name, Integer age) {

        MyPet myPet = new MyPet();
        myPet.setId(id);
        myPet.setType(availablePets);
        myPet.setName(name);
        myPet.setAge(age);

        return petRepository.save(myPet);
    }
}