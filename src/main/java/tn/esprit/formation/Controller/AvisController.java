package tn.esprit.formation.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import tn.esprit.formation.BadWordFilter;
import tn.esprit.formation.DTO.AvisDto;
import tn.esprit.formation.Service.AvisService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("avis")
@CrossOrigin(origins = "http://localhost:4200")
public class AvisController {


    @Autowired
    AvisService avisService;

    @Autowired
    private SentimentAnalyzer sentimentAnalyzer;

@Secured("client")
    @PostMapping("/saveOrUpdate")
    public ResponseEntity<AvisDto> AjouterRecreteur(@Valid @RequestBody AvisDto avisDto) {
        avisDto.setText( BadWordFilter.getCensoredText(avisDto.getText() ));
        AvisDto DTOsaved = avisService.save(avisDto);
        return new ResponseEntity<AvisDto>(DTOsaved, HttpStatus.CREATED);
    }


    @Secured("client")
    @GetMapping("/recherher/{id}")
    public AvisDto recherch(@PathVariable Long id) {
        // TODO Auto-generated method stub
        return avisService.recherch(id);
    }



@Secured("client")
    @GetMapping("/analyzeSentiments")
    public SentimentAnalysisResult analyzeSentiments() {
        List<AvisDto> avisList = avisService.findAll();
        return sentimentAnalyzer.analyze(avisList);
    }








    @GetMapping("/listeavis")
//
    public List<AvisDto> liste() {

        return avisService.findAll();

    }
}
