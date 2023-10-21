package tn.esprit.formation.Service;

import tn.esprit.formation.DTO.StageDTO;

import java.util.List;

public interface StageService {

    StageDTO save(StageDTO stageDTO);
    StageDTO recherch(Long id);

    public void delete(Long id);

    List<StageDTO> findAllstage();

}
