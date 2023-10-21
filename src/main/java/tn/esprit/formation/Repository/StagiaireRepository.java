package tn.esprit.formation.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.esprit.formation.entity.Stagiaire;

@Repository
public interface StagiaireRepository extends JpaRepository<Stagiaire ,Long> {




}
