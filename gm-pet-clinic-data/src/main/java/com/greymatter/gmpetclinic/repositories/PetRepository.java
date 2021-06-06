package com.greymatter.gmpetclinic.repositories;

import com.greymatter.gmpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
