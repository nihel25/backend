package tn.esprit.formation.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.formation.DTO.SpecialiteeDTO;
import tn.esprit.formation.Repository.specialiteeRepository;
import tn.esprit.formation.entity.Specialitee;
import tn.esprit.formation.validations.ObjectsValidator;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OptionServiceImpl implements OptionService{


    @Autowired
    specialiteeRepository specialiteeRepository;

    private final ObjectsValidator<SpecialiteeDTO> objectsValidator;

    public OptionServiceImpl(ObjectsValidator<SpecialiteeDTO> objectsValidator) {
        this.objectsValidator = objectsValidator;
    }


    @Override
    public SpecialiteeDTO ajouterOption(SpecialiteeDTO p) {

        objectsValidator.validate(p);
        Specialitee participant = SpecialiteeDTO.toentity(p);





        Specialitee saved= specialiteeRepository.save(participant);

        return SpecialiteeDTO.fromEntity(saved);

    }

    @Override
    public List<SpecialiteeDTO> findAllspecialite() {
        return specialiteeRepository.findAll()
                .stream()
                .map(SpecialiteeDTO::fromEntity)
                .collect(Collectors.toList());
    }
}
