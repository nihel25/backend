//package tn.esprit.formation.Service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
//import tn.esprit.formation.DTO.CatalogueDTO;
//import tn.esprit.formation.Repository.CatalogueRepository;
//import tn.esprit.formation.Repository.UserRepository;
//import tn.esprit.formation.entity.Catalogue;
//
//import javax.persistence.EntityNotFoundException;
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//@Service
//public class CtalogueServiceImpl implements CtalogueService {
//
//    @Autowired
//    CatalogueRepository catalogueRepository;
//    @Autowired
//    UserRepository userRepository;
//    @Autowired
//    private ImageStorage imageStorage;
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
//    @Override
//    public void delete(Long id) {
//        Catalogue catalogue = catalogueRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id + " not found"));
//        catalogueRepository.deleteById(id);
//    }




//    @Override
//    public List<CatalogueDTO> findAllcatalogue() {
//        return catalogueRepository.findAll()
//                 .stream()
//                .map(CatalogueDTO::fromEntity)
//                .collect(Collectors.toList());
//
//
//    }
//
//
//    public ResponseEntity<Catalogue> findbyId(Long id) {
//        if (id == null) {
//
//            return null;
//        }
//        return ResponseEntity.ok(catalogueRepository.findById(id).get());
//    }
//    @Override
//    public CatalogueDTO savee(CatalogueDTO certificatDTO) {
       //  objectsValidator.validate(certificatDTO);
//        float remise = 0;
//        float prix = 0;
//        certificatDTO.setRemise(certificatDTO.getPrix() * (1 - certificatDTO.getRemise() / 100));
//        Catalogue catalogue = CatalogueDTO.ToEntity(certificatDTO);
//
//        Catalogue savedformateur= catalogueRepository.save(catalogue);
//
//        return CatalogueDTO.fromEntity(savedformateur);
//    }
//
//
//
//
//
//    @Override
//    public CatalogueDTO recherch(Long id) {
//
//        Optional<Catalogue> optionalcatalogue =catalogueRepository.findById(id);
//        if (optionalcatalogue.isPresent()) {
//            Catalogue catalogue=optionalcatalogue.get();
//            return CatalogueDTO.fromEntity(catalogue);
//        }
//        else
//        {
//            return null;
//        }
//    }
//
//
//    @Override
//
//
//
//    public CatalogueDTO uploadImage(Long id, MultipartFile image) {
//        ResponseEntity<Catalogue> catalogueResponse = this.findbyId(id);
//        String imageName = imageStorage.store(image);
//        String fileImageDownloadUrl = ServletUriComponentsBuilder.fromCurrentContextPath().path("/catalogue/downloadImage/").path(imageName).toUriString();
//        Catalogue catalogue = catalogueResponse.getBody();
//        if (catalogue != null)
//            catalogue.setImage(fileImageDownloadUrl);
//        CatalogueDTO catalogueDto = CatalogueDTO.fromEntity(catalogue); // Conversion from Catalogue to CatalogueDto
//        return this.savee(catalogueDto);
//    }
//
//    public Catalogue uploadImage(Long id, MultipartFile image) {
//       ResponseEntity<Catalogue> catalogueResponse = this.findbyId(id);
//        String imageName = imageStorage.store(image);
//        String fileImageDownloadUrl = ServletUriComponentsBuilder.fromCurrentContextPath().path("bureau/downloadImage/").path(imageName).toUriString();
//        Catalogue ctl = catalogueResponse.getBody();
//        if (ctl != null)
//            ctl.setImage(fileImageDownloadUrl);
//        return this.savee(ctl);
//    }
//
//
//
//}
//