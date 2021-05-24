package com.greymatter.gmpetclinic.bootstrap;

import com.greymatter.gmpetclinic.model.Owner;
import com.greymatter.gmpetclinic.model.Pet;
import com.greymatter.gmpetclinic.model.PetType;
import com.greymatter.gmpetclinic.model.Vet;
import com.greymatter.gmpetclinic.services.OwnerService;
import com.greymatter.gmpetclinic.services.PetTypeService;
import com.greymatter.gmpetclinic.services.VetService;
import com.greymatter.gmpetclinic.services.map.OwnerServiceMap;
import com.greymatter.gmpetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

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
        owner1.setAddress("Gregprop Escobvedo 570");
        owner1.setCity("LIMA");
        owner1.setTelephone("991477523");

        Pet pet1 = new Pet();
        pet1.setPetType(savedDogType);
        pet1.setOwner(owner1);
        pet1.setBirthDate(LocalDate.now());
        pet1.setName("Milo");
        owner1.getPets().add(pet1);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiorella");
        owner2.setLastName("Riveiro");
        owner2.setAddress("Gregprop Escobvedo 552");
        owner2.setCity("PIURA");
        owner2.setTelephone("991223323");

        Pet pet2 = new Pet();
        pet2.setPetType(savedCatType);
        pet2.setOwner(owner2);
        pet2.setBirthDate(LocalDate.now());
        pet2.setName("Mishi");
        owner2.getPets().add(pet2);


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
