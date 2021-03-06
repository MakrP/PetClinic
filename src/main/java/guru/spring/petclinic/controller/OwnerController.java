package guru.spring.petclinic.controller;

import guru.spring.petclinic.model.Owner;
import guru.spring.petclinic.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@RequestMapping("/owners")
@Controller
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping({"", "/", "/index", "/index.html"})
    public String ownerList(Model model) {
        Set<Owner> owners = ownerService.findAll();
        model.addAttribute("owners",owners);
        return "owners/index";
    }
}
