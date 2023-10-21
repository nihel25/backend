package tn.esprit.formation.Service;

import org.springframework.web.multipart.MultipartFile;
import tn.esprit.formation.DTO.PersonnelDTO;

public interface PersonnelleService {


    PersonnelDTO recherch(Long id);
    void delete(Long id);
     void chargerDonneesCSV(MultipartFile fichierCSV);
     PersonnelDTO save(PersonnelDTO personnelDTO);

}
