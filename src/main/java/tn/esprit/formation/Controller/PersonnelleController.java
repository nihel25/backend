package tn.esprit.formation.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tn.esprit.formation.DTO.PersonnelDTO;
import tn.esprit.formation.Service.PersonnelleService;

import javax.validation.Valid;

@RestController
@RequestMapping("Personnel")
@CrossOrigin(origins = "http://localhost:4200")
public class PersonnelleController {


@Autowired
    PersonnelleService personnelleService;


    @Secured("coordinateurentreprise")
    @PostMapping("/saveOrUpdate")
    public ResponseEntity<PersonnelDTO> Ajouter(@Valid @RequestBody PersonnelDTO DTO) {
        PersonnelDTO DTOsaved = personnelleService.save(DTO);
        return new ResponseEntity<PersonnelDTO>(DTOsaved, HttpStatus.CREATED);
    }




    @Secured("coordinateurentreprise")

    @PostMapping(value = "/charger-csv", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String chargerCSV(@RequestPart("fichier") MultipartFile fichierCSV) {
        personnelleService.chargerDonneesCSV(fichierCSV);
        return null;
    }








    @Secured("coordinateurentreprise")
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id ) {
        personnelleService.delete(id);
    }




@Secured({"coordinateurentreprise","coordinateurformation"})
    @GetMapping("/recherher/{id}")
    public PersonnelDTO recherch(@PathVariable Long id) {

        return personnelleService.recherch(id);
    }


}
