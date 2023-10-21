package tn.esprit.formation.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import tn.esprit.formation.DTO.DemandeFormationDTO;
import tn.esprit.formation.DTO.FormationDTO;
import tn.esprit.formation.DTO.PersonnelDTO;
import tn.esprit.formation.Service.DemandeformationServiceImpl;
import tn.esprit.formation.entity.Demandeformation;
import tn.esprit.formation.entity.Personnel;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/DemandeFormation")
@CrossOrigin(origins = "http://localhost:4200")
public class DemandeformationController {







    @Autowired
    private DemandeformationServiceImpl demandeFormationService;



    @Secured( "coordinateurentreprise")

    @PostMapping("/demande")
    public ResponseEntity<String> envoyerDemandeFormation(@RequestBody DemandeFormationDTO demandeFormationDTO) {
        Demandeformation demandeFormation = new Demandeformation();
        demandeFormation.setDateCreation(demandeFormationDTO.getDateCreation());

       demandeFormation.setNbrpersonnelle(demandeFormationDTO.getNbrpersonnelle());

        //demandeFormation.setFormation(FormationDTO.toEntity(demandeFormationDTO.getFormationdto()));


        FormationDTO formationdto = demandeFormationDTO.getFormationdto();
        if (formationdto != null) {
            demandeFormation.setFormation(FormationDTO.toEntity(formationdto));
        }


        List<PersonnelDTO> personnelDTOList = demandeFormationDTO.getPersonnelList();
        List<Personnel> personnelList = new ArrayList<>();

        for (PersonnelDTO personnelDTO : personnelDTOList) {
            Personnel personnel = new Personnel();
            personnel.setId(personnelDTO.getId());
            personnel.setNom(personnelDTO.getNom());

            personnelList.add(personnel);
        }

        demandeFormation.setPersonnel(personnelList);
        if (demandeFormationDTO.getId() != null) {
            // Si l'ID est présent dans sessionDTO, il s'agit d'une mise à jour
            demandeFormation.setId(demandeFormationDTO.getId());
            demandeFormationService.add(demandeFormationDTO);
            return null;
        } else {
            // Sinon, il s'agit d'un nouvel ajout
            demandeFormationService.saveDemandeFormation(demandeFormation);
            return null;
        }
    }
















    @Secured( {"coordinateurformation","coordinateurentreprise"})
    @GetMapping("/personnel")
    public ResponseEntity<List<Personnel>> getAllPersonnel() {
        List<Personnel> personnelList = demandeFormationService.getAllPersonnel();
        return ResponseEntity.ok(personnelList);
  }
//
@Secured( "coordinateurformation")
@DeleteMapping("/supprimer/{id}")
public void delete(@PathVariable Long id) {

    demandeFormationService.delete(id);
}







    @Secured( "coordinateurformation")
    @GetMapping("/alldemande")
    public List<DemandeFormationDTO> getAllDemandeFormations() {

        return demandeFormationService.findAllDemandes();
    }

    @Secured( "coordinateurformation")
    @GetMapping("/recherher/{id}")
    public DemandeFormationDTO recherch(@PathVariable Long id) {

        return demandeFormationService.recherch(id);
    }


//    @GetMapping("/{id}/personnel")
//    public ResponseEntity<List<Personnel>> getPersonnelByDemandeFormation(@PathVariable Long id) {
//        List<Personnel> personnelList = demandeFormationService.getPersonnelByDemandeFormation(id);
//        if (!personnelList.isEmpty()) {
//            return ResponseEntity.ok(personnelList);
//        }
//        return ResponseEntity.notFound().build();
//    }
}
