package tn.esprit.formation.Service;

import tn.esprit.formation.DTO.DemandeFormationDTO;
import tn.esprit.formation.entity.Demandeformation;
import tn.esprit.formation.entity.Personnel;

import java.util.List;

public interface DemandeformationService {

    public List<Personnel> getAllPersonnel();
    void delete(Long id);

    DemandeFormationDTO recherch(Long id);
    public List<DemandeFormationDTO> findAllDemandes();
    public void saveDemandeFormation(Demandeformation demandeFormation);
    public DemandeFormationDTO add(DemandeFormationDTO f);
}
