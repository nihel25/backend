package tn.esprit.formation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.formation.entity.Reclamation;

@Repository
public interface ReclamationRepository extends JpaRepository<Reclamation,Long> {


    //  long countByFormation_Id(Long formationId);






}
