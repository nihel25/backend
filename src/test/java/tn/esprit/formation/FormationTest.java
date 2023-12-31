package tn.esprit.formation;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.formation.DTO.*;
import tn.esprit.formation.Repository.FormationRepository;
import tn.esprit.formation.Service.FormationServiceImpl;
import tn.esprit.formation.entity.*;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest

@RunWith(SpringRunner.class)
public class FormationTest {
@Mock
FormationRepository formationRepository;



@InjectMocks
private FormationServiceImpl formationService;
   // @Autowired
   @Before
   public void setUp() {
       MockitoAnnotations.initMocks(this);
   }

    @Test
    public void testSave() {

        FormationDTO formationDTO = new FormationDTO();
        formationDTO.setPrix(3000);

        formationDTO.setRemise(3900);
        formationDTO.setRef("FFE");

        FormateurDto formateurDto = new FormateurDto();
        SpecialiteeDTO specialiteeDTO = new SpecialiteeDTO();
        specialiteeDTO.setTypes("word");
        formateurDto.setSpecialiteedto(specialiteeDTO);

        formationDTO.setFormateurDto(formateurDto);
        userprofilDTO userprofilDTOs =  new userprofilDTO();

        formationDTO.setUserprofildto(userprofilDTOs);


        when(formationRepository.save(any(Formation.class))).thenAnswer(invocation -> {
            Formation savedStage = invocation.getArgument(0);
            savedStage.setId(2L);
            return savedStage;
        });
        FormationDTO savedStageDTO = formationService.save(formationDTO);
        verify(formationRepository, times(1)).save(any(Formation.class));
        assertNotNull(savedStageDTO);
        assertEquals(formationDTO.getPrix(), savedStageDTO.getPrix());
        assertEquals(formationDTO.getRef(), savedStageDTO.getRef());
        assertEquals(formationDTO.getRemise(), savedStageDTO.getRemise());
        assertNotNull(savedStageDTO.getId());
    }













    @Test
    public void testRecherch() {


        Formation formation = new Formation();
        formation.setId(9L);
        formation.setFormationtype("Word");
        Formateur formateur = new Formateur();
        formateur.setSpecialitee(new Specialitee());

        formation.setFormateur(formateur);
        UserProfile userProfile = new UserProfile();

        formation.setUserProfile(userProfile);
        when(formationRepository.findById(9L)).thenReturn(Optional.of(formation));
        FormationDTO foundStageDTO = formationService.recherch(9L);

        assertEquals(formation.getId(), foundStageDTO.getId());
        assertEquals(formation.getFormationtype(), foundStageDTO.getFormationtype());

        // Vérifier l'encadreurDTO
        assertNotNull(foundStageDTO.getFormateurDto());


    }
























}
