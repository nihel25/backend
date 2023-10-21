package tn.esprit.formation.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.formation.entity.Demandeformation;

@Repository
public interface DemandeformationRepository extends JpaRepository<Demandeformation ,Long> {


}
