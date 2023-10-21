package tn.esprit.formation.Service;

import tn.esprit.formation.DTO.CertificatDTO;

import java.util.List;

public interface CertificatService {


    CertificatDTO recherch(Long id);
    CertificatDTO save(CertificatDTO certificatDTO);
    void delete(Long id);
    List<CertificatDTO> findAll();
}
