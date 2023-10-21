package tn.esprit.formation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.formation.entity.Personnel;

@Repository
public interface PersonnelRepository extends JpaRepository<Personnel, Long> {

}

