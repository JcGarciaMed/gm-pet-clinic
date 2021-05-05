package com.greymatter.gmpetclinic.services;

import com.greymatter.gmpetclinic.model.Pet;
import com.greymatter.gmpetclinic.model.Vet;

import java.util.Set;

public interface VetService {
    Vet findById(Long id);
    Vet save(Vet vet);
    Set<Vet> findAll();
}
