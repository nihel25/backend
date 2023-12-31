package tn.esprit.formation.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.formation.DTO.MaterielDTO;
import tn.esprit.formation.Repository.MaterielRepository;
import tn.esprit.formation.entity.Materiel;
import tn.esprit.formation.validations.ObjectsValidator;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MaterielServiceImpl implements MaterielService{


    @Autowired
    MaterielRepository materielRepository;


    private final ObjectsValidator<MaterielDTO> objectsValidator;

    public MaterielServiceImpl(ObjectsValidator<MaterielDTO> objectsValidator) {
        this.objectsValidator = objectsValidator;
    }











    @Override
    public List<MaterielDTO> findAllreclamation() {
        return materielRepository.findAll()
                .stream()
                .map(MaterielDTO::fromentity)
                .collect(Collectors.toList());
    }

    @Override
    public MaterielDTO save(MaterielDTO materielDTO) {

        objectsValidator.validate(materielDTO);
        Materiel materiel=materielDTO.toentity(materielDTO);
        materielRepository.save(materiel);
        MaterielDTO DTOsaved=materielDTO.fromentity(materiel);
        return DTOsaved;

    }

    @Override
    public MaterielDTO recherch(Long id) {
        Optional<Materiel> optionalmateriel =materielRepository.findById(id);
        if (optionalmateriel.isPresent()) {
            Materiel materiel=optionalmateriel.get();
            return MaterielDTO.fromentity(materiel);
        }
        else
        {
            return null;
        }}


    @Override
    public void delete(Long id) {
        Materiel materiel = materielRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id + " not found"));
        materielRepository.deleteById(id);
    }
}
