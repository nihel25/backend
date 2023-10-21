package tn.esprit.formation.Service;

import tn.esprit.formation.DTO.StagiaireDTO;
import tn.esprit.formation.entity.Stagiaire;

import java.util.List;

public interface StagiaireService extends GenericInterface<StagiaireDTO>{


    Stagiaire retrievebyid(Long id);
    List<StagiaireDTO> findAll();

    StagiaireDTO save(StagiaireDTO stagiaireDTO);
    StagiaireDTO recherch(Long id);
}
