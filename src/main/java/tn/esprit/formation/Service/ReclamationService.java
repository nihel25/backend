package tn.esprit.formation.Service;

import tn.esprit.formation.DTO.ReclamationDTO;

import java.util.List;

public interface ReclamationService {







    List<ReclamationDTO> findAllreclamation();

    ReclamationDTO save(ReclamationDTO reclamationDTO);
    ReclamationDTO recherch(Long id);
    void delete(Long id);
}
