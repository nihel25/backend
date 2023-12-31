package tn.esprit.formation.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import tn.esprit.formation.DTO.PersonnelDTO;
import tn.esprit.formation.Repository.PersonnelRepository;
import tn.esprit.formation.entity.Personnel;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Optional;


@Service
public class PersonnelleServiceImpl implements PersonnelleService{
    @Autowired
    PersonnelRepository personnelRepository;


    @Override
    @Transactional
    public void chargerDonneesCSV(MultipartFile fichierCSV) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(fichierCSV.getInputStream()))) {
            String ligne;
            while ((ligne = reader.readLine()) != null) {
                String[] colonnes = ligne.split(";");

                // Check if the array has the expected number of elements
                if (colonnes.length >= 5) {
                    String nom = colonnes[0];
                    String prenom = colonnes[1];
                    String cin = colonnes[2];
                    String email = colonnes[3];
                    String fonction = colonnes[4];

                    Personnel personnel = new Personnel();
                    personnel.setNom(nom);
                    personnel.setPrenom(prenom);
                    personnel.setCin(cin);
                    personnel.setEmail(email);
                    personnel.setFonction(fonction);

                    personnelRepository.save(personnel);
                } else {

                    System.out.println("Invalid line format: " + ligne);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }














    @Override
    public PersonnelDTO recherch(Long id) {
        Optional<Personnel> optionalpersonnelle = personnelRepository.findById(id);
        if (optionalpersonnelle.isPresent()) {
            Personnel stagiaire = optionalpersonnelle.get();
            return PersonnelDTO.fromentity(stagiaire);
        } else {
            return null;
        }


    }

    @Override
    public void delete(Long id) {
        Personnel participant = personnelRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id + " not found"));
        personnelRepository.deleteById(id);
    }

    @Override
    public PersonnelDTO save(PersonnelDTO personnelDTO) {
        Personnel personnel = PersonnelDTO.toentity(personnelDTO);
        personnelRepository.save(personnel);
        PersonnelDTO personneldto = PersonnelDTO.fromentity(personnel);
        return personneldto;

    }
}
