package guru.spring.petclinic.bootstrap;

import guru.spring.petclinic.model.*;
import guru.spring.petclinic.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class DataInitializer implements CommandLineRunner {

    private final OwnerService ownerService;
    private final PetService petService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

    public DataInitializer(OwnerService ownerService, PetService petService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.petService = petService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception {
        PetType dogType = new PetType();
        dogType.setName("Dog");

        PetType catType = new PetType();
        catType.setName("Cat");

        PetType savedDogType = petTypeService.save(dogType);
        PetType savedCatType = petTypeService.save(catType);

        Pet pet1 = new Pet();
        pet1.setName("Pet dog name1");
        pet1.setType(savedDogType);
        Pet pet2 = new Pet();
        pet2.setName("Pet cat name2");
        pet2.setType(savedCatType);

        petService.save(pet1);
        petService.save(pet2);


        Owner owner1 = new Owner();
        owner1.setFirstName("Owner FN1");
        owner1.setLastName("Owner LN1");
        owner1.setAddress("Lukasha 5");
        owner1.setCity("Lviv");
        owner1.setPhone("0733423432");
        owner1.setPets(Set.of(pet1));
        Owner owner2 = new Owner();
        owner2.setFirstName("Owner FN2");
        owner2.setLastName("Owner LN2");
        owner2.setAddress("Kovaliva 43");
        owner2.setCity("Boryslav");
        owner2.setPhone("5534325324");
        owner2.setPets(Set.of(pet2));

        ownerService.save(owner1);
        ownerService.save(owner2);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");

        Speciality dentist = new Speciality();
        surgery.setDescription("Dentist");

        specialityService.save(surgery);
        specialityService.save(dentist);

        Speciality savedSurgery = specialityService.findById(1L);
        Speciality savedDentist = specialityService.findById(2L);

        Vet vet1 = new Vet();
        vet1.setFirstName("Vet FN 1");
        vet1.setLastName("Vet LN 1");
        vet1.setSpecialities(Set.of(savedSurgery));

        Vet vet2 = new Vet();
        vet2.setFirstName("Vet FN 2");
        vet2.setLastName("Vet LN 2");
        vet2.setSpecialities(Set.of(savedDentist));
        Vet vet3 = new Vet();
        vet3.setFirstName("Vet FN 3");
        vet3.setLastName("Vet LN 3");
        vet3.setSpecialities(Set.of(savedSurgery, savedDentist));
        vetService.save(vet1);
        vetService.save(vet2);
        vetService.save(vet3);

    }
}
