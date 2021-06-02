package guru.spring.petclinic.controller;

import guru.spring.petclinic.service.PetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/pets")
public class PetController {

    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping({"/", "", "index", "index.html"})
    public String petsList(Model model) {
        model.addAttribute("pets",petService.findAll());
        return "pets/index";
    }
}

