package tn.esprit.formation.Service;

import tn.esprit.formation.DTO.SpecialiteeDTO;

import java.util.List;

public interface OptionService {


    public SpecialiteeDTO ajouterOption(SpecialiteeDTO p);

    List<SpecialiteeDTO> findAllspecialite();
}
