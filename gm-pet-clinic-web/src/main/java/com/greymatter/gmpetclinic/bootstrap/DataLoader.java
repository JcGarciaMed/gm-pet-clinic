package com.greymatter.gmpetclinic.bootstrap;

import com.greymatter.gmpetclinic.model.*;
import com.greymatter.gmpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if (count== 0){
            loadData();
        }
    }

    private void loadData() {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatType = petTypeService.save(cat);

        System.out.println("Loading Pet Types");

        Specialty specialty1 = new Specialty();
        specialty1.setDescription("radiology");
        Specialty savedSpecialty1 = specialtyService.save(specialty1);
        Specialty specialty2 = new Specialty();
        specialty2.setDescription("surgery");
        Specialty savedSpecialty2 = specialtyService.save(specialty2);
        Specialty specialty3 = new Specialty();
        specialty3.setDescription("dentistry");
        Specialty savedSpecialty3 = specialtyService.save(specialty3);

        System.out.println("Loading Specialties");


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

        Visit visit = new Visit();
        visit.setPet(pet2);
        visit.setDate(LocalDate.now());
        visit.setDescription("Sneeze Kitty");
        visitService.save(visit);

        System.out.println("Loading Owners");

        Vet vet1 = new Vet();
        vet1.setFirstName("Andriy");
        vet1.setLastName("Shevchenko");
        vet1.getSpecialties().add(savedSpecialty1);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Sam");
        vet2.setLastName("Cooke");
        vet2.getSpecialties().add(savedSpecialty2);
        vet2.getSpecialties().add(savedSpecialty3);

        vetService.save(vet2);

        System.out.println("Loading Vets......");
    }
}
