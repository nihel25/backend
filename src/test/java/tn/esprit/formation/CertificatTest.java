package tn.esprit.formation;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.formation.DTO.CertificatDTO;
import tn.esprit.formation.DTO.EncadreurDTO;
import tn.esprit.formation.DTO.StageDTO;
import tn.esprit.formation.DTO.StagiaireDTO;
import tn.esprit.formation.Repository.CertificatRepository;
import tn.esprit.formation.Service.CertificatServiceImpl;
import tn.esprit.formation.entity.Certificat;
import tn.esprit.formation.entity.Encadreur;
import tn.esprit.formation.entity.Stage;
import tn.esprit.formation.entity.Stagiaire;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CertificatTest {



@Mock
    CertificatRepository certificatRepository;
@InjectMocks
    CertificatServiceImpl certificatService;



    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSave() {

        CertificatDTO certificatDTO = new CertificatDTO();
        certificatDTO.setId(1L);

        EncadreurDTO encadreurDTO = new EncadreurDTO();
        encadreurDTO.setId(1L);
        certificatDTO.setEncadreurDTO(encadreurDTO);

        StagiaireDTO stagiaireDTO1 = new StagiaireDTO();
        stagiaireDTO1.setId(8L);
        StageDTO stageDTO = new StageDTO();
        stageDTO.setId(7L);
        stageDTO.setEncadreurDTO(encadreurDTO);
        stagiaireDTO1.setStagedto(stageDTO);
        certificatDTO.setStagiairedto(stagiaireDTO1);
        when(certificatRepository.save(any(Certificat.class))).thenAnswer(invocation -> {
            Certificat savedStage = invocation.getArgument(0);
            savedStage.setId(1L);
            return savedStage;
        });
        CertificatDTO savedStageDTO = certificatService.save(certificatDTO);
        verify(certificatRepository, times(1)).save(any(Certificat.class));
        assertNotNull(savedStageDTO);
        assertEquals(certificatDTO.getId(), savedStageDTO.getId());

        assertNotNull(savedStageDTO.getId());
    }





    @Test
    public void testRecherch() {

        Stage stage = new Stage();
        Certificat certificat = new Certificat();
        certificat.setId(2L);
        Stagiaire stagiaire = new Stagiaire();
        stagiaire.setStage(new Stage());
        stagiaire.setStage(stage);
        certificat.setStagiaire(stagiaire);
        Encadreur encadreur = new Encadreur();
        EncadreurDTO encadreurDTO = new EncadreurDTO();
        encadreurDTO.setId(1L);
        encadreurDTO.setNom("mabrouki");
        encadreurDTO.setEmail("akrem@gmail.com");
certificat.setEncadreur(encadreur);
        when(certificatRepository.findById(1L)).thenReturn(Optional.of(certificat));
        CertificatDTO foundStageDTO = certificatService.recherch(2L);




    }













    @Test
    public void testFindAllCertificat() {
        Certificat certificat = new Certificat();
        certificat.setId(1L);
Stagiaire stagiaire= new Stagiaire();

        Encadreur encadreur = new Encadreur();
//        encadreur.setId(1L);
//        encadreur.setPrenom("akrem");
//        encadreur.setEmail("akrem@gmail.com");
        Stage stage = new Stage();
        stagiaire.setStage(stage);
        stage.setId(7L);
        stage.setEncadreur(encadreur);
        certificat.setEncadreur(encadreur);
certificat.setStagiaire(stagiaire);
        when(certificatRepository.findAll()).thenReturn(Arrays.asList(certificat));
        List<CertificatDTO> stageDTOList = certificatService.findAll();
        assertEquals(1, stageDTOList.size());
        assertEquals(certificat.getId(), stageDTOList.get(0).getId());
        //assertEquals(certificat.getEncadreur(), stageDTOList.get(0).getEncadreurDTO());
       // assertEquals(certificat.getStagiaire(), stageDTOList.get(0).getStagiairedto());

    }
}
