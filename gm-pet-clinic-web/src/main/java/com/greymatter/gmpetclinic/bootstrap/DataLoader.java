package com.greymatter.gmpetclinic.bootstrap;

import com.greymatter.gmpetclinic.model.Owner;
import com.greymatter.gmpetclinic.model.Vet;
import com.greymatter.gmpetclinic.services.OwnerService;
import com.greymatter.gmpetclinic.services.VetService;
import com.greymatter.gmpetclinic.services.map.OwnerServiceMap;
import com.greymatter.gmpetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        this.ownerService = new OwnerServiceMap();
        this.vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(261L);
        owner1.setFirstName("Jorge");
        owner1.setLastName("Garcia");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(233L);
        owner2.setFirstName("Fiorella");
        owner2.setLastName("Riveiro");

        ownerService.save(owner2);

        System.out.println("Loading Owners");

        Vet vet1 = new Vet();
        vet1.setId(465L);
        vet1.setFirstName("Andriy");
        vet1.setLastName("Shevchenko");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(3465L);
        vet2.setFirstName("Sam");
        vet2.setLastName("Cooke");

        vetService.save(vet2);

        System.out.println("Loading Vets......");

    }
}
