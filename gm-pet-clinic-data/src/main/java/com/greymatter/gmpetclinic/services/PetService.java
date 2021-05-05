package com.greymatter.gmpetclinic.services;

import com.greymatter.gmpetclinic.model.Owner;
import com.greymatter.gmpetclinic.model.Pet;

import java.util.Set;

public interface PetService {
    Pet findById(Long id);
    Pet save(Pet pet);
    Set<Pet> findAll();
}
