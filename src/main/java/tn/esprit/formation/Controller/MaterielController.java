package tn.esprit.formation.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import tn.esprit.formation.DTO.MaterielDTO;
import tn.esprit.formation.Service.MaterielService;
import tn.esprit.formation.Service.MaterielServiceImpl;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("Materiel")
@CrossOrigin(origins = "http://localhost:4200")
public class MaterielController {


@Autowired
    MaterielService materielService;
    @Autowired
    MaterielServiceImpl materielServices;
    @Secured("coordinateurformation")
    @PostMapping("/saveOrUpdate")
    public ResponseEntity<MaterielDTO> AjouterRecreteur(@Valid @RequestBody MaterielDTO materielDTO) {
        MaterielDTO DTOsaved = materielService.save(materielDTO);
        return new ResponseEntity<MaterielDTO>(DTOsaved, HttpStatus.CREATED);
    }









    //@PreAuthorize("hasAnyRole('coordinateurformation')")
    @Secured("coordinateurformation")
    @GetMapping("/recherher/{id}")
    public MaterielDTO recherch(@PathVariable Long id) {
        // TODO Auto-generated method stub
        return materielService.recherch(id);
    }
   // @PreAuthorize("hasAnyRole('coordinateurformation')")
   @Secured("coordinateurformation")
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        materielService.delete(id);
    }
    //@PreAuthorize("hasAnyRole('coordinateurformation')")
    @Secured("coordinateurformation")
    @GetMapping("/lister")
    public List<MaterielDTO> liste() {
        return materielService.findAllreclamation();
    }

}
