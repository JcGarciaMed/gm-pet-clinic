package com.greymatter.gmpetclinic.bootstrap;

import com.greymatter.gmpetclinic.model.Owner;
import com.greymatter.gmpetclinic.model.PetType;
import com.greymatter.gmpetclinic.model.Vet;
import com.greymatter.gmpetclinic.services.OwnerService;
import com.greymatter.gmpetclinic.services.PetTypeService;
import com.greymatter.gmpetclinic.services.VetService;
import com.greymatter.gmpetclinic.services.map.OwnerServiceMap;
import com.greymatter.gmpetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatType = petTypeService.save(cat);

        System.out.println("Loading Pet Types");


        Owner owner1 = new Owner();
        owner1.setFirstName("Jorge");
        owner1.setLastName("Garcia");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiorella");
        owner2.setLastName("Riveiro");

        ownerService.save(owner2);

        System.out.println("Loading Owners");

        Vet vet1 = new Vet();
        vet1.setFirstName("Andriy");
        vet1.setLastName("Shevchenko");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Sam");
        vet2.setLastName("Cooke");

        vetService.save(vet2);

        System.out.println("Loading Vets......");

    }
}
