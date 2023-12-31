package tn.esprit.formation.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.formation.DTO.EncadreurDTO;
import tn.esprit.formation.Repository.EncadreurRepository;
import tn.esprit.formation.entity.Encadreur;
import tn.esprit.formation.validations.ObjectsValidator;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EncadreurServiceImp implements EncadreurService{
@Autowired
    EncadreurRepository encadreurRepository;


private EncadreurDTO encadreurDTO;

    private final ObjectsValidator<EncadreurDTO> objectsValidator;

    public EncadreurServiceImp(ObjectsValidator<EncadreurDTO> objectsValidator) {
        this.objectsValidator = objectsValidator;
    }



//
    @Override
    public EncadreurDTO save(EncadreurDTO encadreurDTO) {
        objectsValidator.validate(encadreurDTO);
        Encadreur encadreur=encadreurDTO.toEntity(encadreurDTO);
        encadreurRepository.save(encadreur);
        EncadreurDTO encadreurDTOsaved=encadreurDTO.fromEntity(encadreur);
        return encadreurDTOsaved;

    }




    @Override
    public void delete(Long id) {

        encadreurRepository.deleteById(id);
    }

    @Override
    public List<EncadreurDTO> findAll() {
        return encadreurRepository.findAll()
                .stream()
                .map(EncadreurDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
//
    public EncadreurDTO recherch(Long id) {
        Optional<Encadreur> optionalEncadreur =encadreurRepository.findById(id);
        if (optionalEncadreur.isPresent()) {
            Encadreur encadreur=optionalEncadreur.get();
            return encadreurDTO.fromEntity(encadreur);
        }
        else
        {
            return null;
        }}}

//