package tn.esprit.formation.Service;

import tn.esprit.formation.DTO.SalleDTO;
import tn.esprit.formation.entity.Salle;

import java.util.List;

public interface SalleService {

    public void ajoutersalle(Salle s);
    void delete(Long id);
    void findid(Long id);
    Salle retrievesallebyid(Long id);
    List<SalleDTO> findAllSalle();

    public SalleDTO save(SalleDTO salleDTO);

    SalleDTO recherch(Long id);
}
