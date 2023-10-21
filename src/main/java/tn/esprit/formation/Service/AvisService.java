package tn.esprit.formation.Service;

import tn.esprit.formation.DTO.AvisDto;

import java.util.List;

public interface AvisService {
    public AvisDto recherch(Long id);
    AvisDto save(AvisDto avisDto);
    List<AvisDto> findAll();
}
