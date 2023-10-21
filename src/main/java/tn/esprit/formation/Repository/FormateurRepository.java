package tn.esprit.formation.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.formation.entity.Formateur;

@Repository
public interface FormateurRepository extends JpaRepository<Formateur, Long> {





}
