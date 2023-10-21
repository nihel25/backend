package tn.esprit.formation.Service;

import tn.esprit.formation.DTO.MaterielDTO;

import java.util.List;

public interface MaterielService {

    List<MaterielDTO> findAllreclamation();

    MaterielDTO save(MaterielDTO materielDTO);
    MaterielDTO recherch(Long id);
    void delete(Long id);
}
