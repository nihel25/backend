package tn.esprit.formation.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import tn.esprit.formation.DTO.ReclamationDTO;
import tn.esprit.formation.Service.ReclamationService;
import tn.esprit.formation.Service.ReclamationServiceImpl;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("Reclamation")
@CrossOrigin(origins = "http://localhost:4200")
public class ReclamationController {
    @Autowired
    ReclamationService reclamationService;
    @Autowired
    ReclamationServiceImpl reclamationServicee;


    @Secured("client")
    @PostMapping("/saveOrUpdate")
    public ResponseEntity<ReclamationDTO> AjouterReclamation(@Valid @RequestBody ReclamationDTO reclamationDTO) {


        ReclamationDTO DTOsaved = reclamationService.save(reclamationDTO);
        return new ResponseEntity<ReclamationDTO>(DTOsaved, HttpStatus.CREATED);
    }
    @Secured("coordinateurformation")
    @GetMapping("/recherher/{id}")
    public ReclamationDTO recherch(@PathVariable Long id) {
        return reclamationService.recherch(id);
    }




    @Secured("coordinateurformation")
    @GetMapping("/findAllreclamation")
    public List<ReclamationDTO> findAllreclamation() {

        return reclamationServicee.findAllreclamation();

    }

    @Secured("coordinateurformation")
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        reclamationServicee.delete(id);
    }
}
