package tn.esprit.formation.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import tn.esprit.formation.DTO.SpecialiteeDTO;
import tn.esprit.formation.Service.OptionService;

import java.util.List;

@RestController
@RequestMapping("Option")
@CrossOrigin(origins = "http://localhost:4200")
public class OptionController {


    @Autowired
    OptionService optionService;


    @Secured("ADMIN")

    @PostMapping("/ajouteroption")
    public SpecialiteeDTO addoption(@RequestBody SpecialiteeDTO p){



        return  optionService.ajouterOption(p);
    }




@Secured("ADMIN")

    @GetMapping("/lister")
    public List<SpecialiteeDTO> liste() {
        return optionService.findAllspecialite();
    }












}
