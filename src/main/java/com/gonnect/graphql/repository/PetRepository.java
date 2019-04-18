package com.gonnect.graphql.repository;

import com.gonnect.graphql.entities.MyPet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


@Repository
public interface PetRepository extends JpaRepository<MyPet, String>, JpaSpecificationExecutor<MyPet> {
}

