package tn.esprit.formation;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.formation.DTO.EncadreurDTO;
import tn.esprit.formation.DTO.StageDTO;
import tn.esprit.formation.DTO.StagiaireDTO;
import tn.esprit.formation.Repository.StagiaireRepository;
import tn.esprit.formation.Service.StagiaireServiceImp;
import tn.esprit.formation.entity.Encadreur;
import tn.esprit.formation.entity.Stage;
import tn.esprit.formation.entity.Stagiaire;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
@SpringBootTest
@RunWith(SpringRunner.class)
public class StagiaireServiceTest {













    @Mock
    private StagiaireRepository stagiaireRepository;

    @InjectMocks
    private StagiaireServiceImp stagiaireServiceImp;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSave() {

        StagiaireDTO stagiaireDTO = new StagiaireDTO();
        stagiaireDTO.setCin("14254687");

        stagiaireDTO.setPrenom("amin");
        StageDTO stageDTO = new StageDTO();
        stagiaireDTO.setStagedto(stageDTO);
        Encadreur encadreur = new Encadreur();
        encadreur.setId(1L);
        EncadreurDTO encadreurDTO = new EncadreurDTO();
        stageDTO.setEncadreurDTO(encadreurDTO);
        when(stagiaireRepository.save(any(Stagiaire.class))).thenAnswer(invocation -> {
            Stagiaire savedStage = invocation.getArgument(0);
            savedStage.setId(1L);
            return savedStage;
        });
        StagiaireDTO savedStageDTO = stagiaireServiceImp.save(stagiaireDTO);
        verify(stagiaireRepository, times(1)).save(any(Stagiaire.class));
        assertNotNull(savedStageDTO);
        assertEquals(stagiaireDTO.getPrenom(), savedStageDTO.getPrenom());
        assertEquals(stagiaireDTO.getCin(), savedStageDTO.getCin());
        assertNotNull(savedStageDTO.getId());
    }





















    @Test
    public void testRecherch() {
        // Créer un objet Stage pour le test
        StageDTO stageDTO = new StageDTO();
       // stageDTO.setId(1L);
        //stageDTO.getDuree(180L);
        stageDTO.setNomService("informatique");


        Stagiaire stagiaire = new Stagiaire();
        stagiaire.setId(8L);
        stagiaire.setCin("17852538");
        Stage stage = new Stage();
        stage.setEncadreur(new Encadreur());
        stagiaire.setStage(stage);


        EncadreurDTO encadreurDTO = new EncadreurDTO();
        encadreurDTO.setId(1L);
        encadreurDTO.setNom("mabrouki");
        encadreurDTO.setEmail("akrem@gmail.com");

        when(stagiaireRepository.findById(8L)).thenReturn(Optional.of(stagiaire));


        StagiaireDTO foundStageDTO = stagiaireServiceImp.recherch(8L);


        assertEquals(stagiaire.getId(), foundStageDTO.getId());
        assertEquals(stagiaire.getCin(), foundStageDTO.getCin());
        assertNotNull(foundStageDTO.getStagedto());

    }












//    @Test
//    public void testRecherch_Echec_IdInexistant() {
//        when(stagiaireRepository.findById(8L)).thenReturn(Optional.empty());
//
//
//        StagiaireDTO foundStageDTO = stagiaireServiceImp.recherch(8L);
//        assertNotNull(foundStageDTO);
//
//
  //       Vérifications
//
//    }
    @Test
    public void testFindAllstagiaire() {
        Stagiaire stagiaire = new Stagiaire();
        stagiaire.setId(8L);
        stagiaire.setCin("17852538");
        Encadreur encadreur = new Encadreur();
        encadreur.setId(1L);
        Stage stage = new Stage();
        stage.setId(7L);
        stage.setEncadreur(encadreur);
        stagiaire.setStage(stage);
        when(stagiaireRepository.findAll()).thenReturn(Arrays.asList(stagiaire));
        List<StagiaireDTO> stageDTOList = stagiaireServiceImp.findAll();
        assertEquals(1, stageDTOList.size());
        assertEquals(stagiaire.getId(), stageDTOList.get(0).getId());
        assertEquals(stagiaire.getCin(), stageDTOList.get(0).getCin());

    }







}
