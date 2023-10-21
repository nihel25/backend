package tn.esprit.formation.Service;

import tn.esprit.formation.DTO.FormateurDto;

import java.util.List;

public interface FormateurService {

    FormateurDto addformateur(FormateurDto b);

    List<FormateurDto> findAll();
   // List<FormateurDto> listerformateurbyoption(String specialite);


    FormateurDto recherch(Long id);
    FormateurDto save(FormateurDto formateurDto);
    void delete(Long id);



}

