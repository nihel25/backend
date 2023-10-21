package tn.esprit.formation.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.formation.DTO.CertificatDTO;
import tn.esprit.formation.Repository.CertificatRepository;
import tn.esprit.formation.entity.Certificat;
import tn.esprit.formation.validations.ObjectsValidator;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class CertificatServiceImpl implements CertificatService{
@Autowired
CertificatRepository certificatRepository;


    private final ObjectsValidator<CertificatDTO> objectsValidator;

    public CertificatServiceImpl(ObjectsValidator<CertificatDTO> objectsValidator) {
        this.objectsValidator = objectsValidator;
    }
    @Override
    public CertificatDTO recherch(Long id) {
        Optional<Certificat> optionalcertificat =certificatRepository.findById(id);
        if (optionalcertificat.isPresent()) {
            Certificat certificat=optionalcertificat.get();
            return CertificatDTO.fromentity(certificat);
        }
        else
        {
            return null;
        }
    }

    @Override
    public CertificatDTO save(CertificatDTO certificatDTO) {
        //objectsValidator.validate(certificatDTO);

        Certificat certificat = CertificatDTO.toentity(certificatDTO);

        Certificat savedformateur= certificatRepository.save(certificat);

        return CertificatDTO.fromentity(savedformateur);
    }

    @Override
    public void delete(Long id) {
        Certificat certificat = certificatRepository.findById(id).orElseThrow(()->new EntityNotFoundException(id+" not found"));
        certificatRepository.deleteById(id);
    }

    @Override
    public List<CertificatDTO> findAll() {
        return certificatRepository.findAll()
                .stream()
                .map(CertificatDTO::fromentity)
                .collect(Collectors.toList());
    }
}
