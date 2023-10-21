//package tn.esprit.formation.Service;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.webjars.NotFoundException;
//import tn.esprit.formation.DTO.FactureDTO;
//import tn.esprit.formation.Repository.FactureRepository;
//import tn.esprit.formation.Repository.FormationRepository;
//import tn.esprit.formation.entity.Facture;
//
//import javax.persistence.EntityNotFoundException;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//public class FactureServiceImpl implements FactureService {
//
//
//    @Autowired
//    FactureRepository factureRepository;
//
//@Autowired
//    FormationRepository formationRepository;
//
//
//
//
//    public Facture getFactureById(Long id) {
//        return factureRepository.findById(id)
//                .orElseThrow(() -> new NotFoundException("Facture non trouvée avec l'ID : " + id));
//    }
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//




































//@Override
//    public FactureDTO recherch(Long id) {
//        return null;
//    }
//
//    @Override
//    public FactureDTO save(FactureDTO factureDTO) {
//        Facture facture=factureDTO.Toentity(factureDTO);
//        float qte=0;
//         float montantFacture=0;
//         float totalefacture=0;
//
//
//        factureDTO.setTotalefacture(factureDTO.getQte()*factureDTO.getMontantFacture());
//        factureRepository.save(facture);
//        FactureDTO DTOsaved=factureDTO.fromEntity(facture);
//        return DTOsaved;
//    }
//
//    @Override
//    public void delete(Long id) {
//        Facture facture = factureRepository.findById(id).orElseThrow(()->new EntityNotFoundException(id+" not found"));
//        factureRepository.deleteById(id);
//    }
//
//    @Override
//    public List<FactureDTO> findAllfacture() {
//        return factureRepository.findAll()
//                .stream()
//                .map(FactureDTO::fromEntity)
//                .collect(Collectors.toList());
//    }
//
//
//}
