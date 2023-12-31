package tn.esprit.formation.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import tn.esprit.formation.Repository.UserProfileRepository;
import tn.esprit.formation.entity.UserProfile;

import javax.transaction.Transactional;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

@Service
public class UserProfileService {


    @Autowired
    UserProfileRepository userProfileRepository;



    @Transactional
    public void chargerDonneesCSV(MultipartFile fichierCSV) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(fichierCSV.getInputStream()))) {
            String ligne;
            while ((ligne = reader.readLine()) != null) {
                String[] colonnes = ligne.split(";");


                // Check if the array has the expected number of elements
                if (colonnes.length >= 5) {
                    String age = colonnes[0];
                    String niveauEtudes = colonnes[1];
                    String heuresDisponiblesSemaine = colonnes[2];
                    String montantBudget = colonnes[3];
                    String nombrePersonnesGroupe = colonnes[4];
                    String formatFormation = colonnes[5];
                    String engagementsProfessionnels = colonnes[6];

                    UserProfile personnel = new UserProfile();




                    personnel.setAge(age);
                    personnel.setNiveauEtudes(niveauEtudes);
                    personnel.setHeuresDisponiblesSemaine(heuresDisponiblesSemaine);
                    personnel.setMontantBudget(montantBudget);
                    personnel.setNombrePersonnesGroupe(nombrePersonnesGroupe);
                    personnel.setFormatFormation(formatFormation);
                    personnel.setEngagementsProfessionnels(engagementsProfessionnels);

                    userProfileRepository.save(personnel);
                } else {

                    System.out.println("Invalid line format: " + ligne);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public List<UserProfile> getAllUserProfiles() {
        return userProfileRepository.findAll();
    }

}
