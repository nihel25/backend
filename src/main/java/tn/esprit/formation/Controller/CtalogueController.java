//package tn.esprit.formation.Controller;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.io.Resource;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.annotation.Secured;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//import tn.esprit.formation.DTO.CatalogueDTO;
//import tn.esprit.formation.Service.CtalogueService;
//import tn.esprit.formation.Service.ImageStorage;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.validation.Valid;
//import java.util.List;
//
//@RestController
//@RequestMapping("/catalogue")
//@CrossOrigin(origins = "http://localhost:4200")
//public class CtalogueController {
//    @Autowired
//    private ImageStorage imageStorage;
//
//
//
//    @Autowired
//    CtalogueService ctalogueService;
//
//
//
//@Secured("coordinateurformation")
//    @DeleteMapping("/delete/{id}")
//    public void delete(@PathVariable Long id ) {
//        ctalogueService.delete(id);
//    }
//    @Secured("coordinateurformation")
//    @PostMapping("/saveOrUpdate")
//    public ResponseEntity<CatalogueDTO> Ajouter(@Valid @RequestBody CatalogueDTO certificatDTO) {
//        CatalogueDTO DTOsaved = ctalogueService.savee(certificatDTO);
//        return new ResponseEntity<CatalogueDTO>(DTOsaved, HttpStatus.CREATED);
//    }
//
//
//
//    @Secured({"client", "coordinateurformation","coordinateurentreprise"})
//    @GetMapping("/findAllcatalogue")
//    public List<CatalogueDTO> findall() {
//
//        return ctalogueService.findAllcatalogue();
//
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





//    @Secured( "coordinateurformation")
//
//    @GetMapping("/recherher/{id}")
//    public CatalogueDTO recherch(@PathVariable Long id) {
//
//        return ctalogueService.recherch(id);
//    }
//    @Secured( "coordinateurformation")
//    @PostMapping("/uploadImage/{id}")
//    public CatalogueDTO uploadImagecatalogue(@PathVariable Long id, MultipartFile image) {
//        return ctalogueService.uploadImage(id, image);
//    }
//
//    @Secured( "coordinateurformation")
//    @GetMapping("/downloadImage/{imageName}")
//    public ResponseEntity<Resource> downloadImage(@PathVariable String imageName, HttpServletRequest request) {
//        return this.imageStorage.downloadUserImage(imageName, request);
//    }
//}