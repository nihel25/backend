package tn.esprit.formation.Service;

import tn.esprit.formation.DTO.EncadreurDTO;

import java.util.List;

public interface EncadreurService {

    EncadreurDTO recherch(Long id);
    EncadreurDTO save(EncadreurDTO encadreurDTO);
    void delete(Long id);
    List<EncadreurDTO> findAll();



}
