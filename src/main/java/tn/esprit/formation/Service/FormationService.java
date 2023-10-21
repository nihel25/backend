package tn.esprit.formation.Service;

import org.springframework.web.multipart.MultipartFile;
import tn.esprit.formation.DTO.FormationDTO;
import tn.esprit.formation.entity.Formation;

import java.util.List;

public interface FormationService {

    FormationDTO save(FormationDTO dto);
    void delete(Long id);

    List<FormationDTO> findAllFormation();


    public List<Formation> getAllFormations();
  //  List<FormationDTO> findformationbyFormateur(String nom,String prenom);

    public FormationDTO uploadImage(Long id, MultipartFile image);


    FormationDTO recherch(Long id);
}
