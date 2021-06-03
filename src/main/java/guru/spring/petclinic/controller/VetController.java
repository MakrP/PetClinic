package guru.spring.petclinic.controller;

import guru.spring.petclinic.model.Vet;
import guru.spring.petclinic.service.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@RequestMapping({"/vets","/vets.html"})
@Controller
public class VetController {

    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @GetMapping({"", "/", "/index", "/index.html"})
    public String vetsList(Model model) {
        Set<Vet> vets = vetService.findAll();
        model.addAttribute("vets", vets);
        return "vets/index";
    }
}
