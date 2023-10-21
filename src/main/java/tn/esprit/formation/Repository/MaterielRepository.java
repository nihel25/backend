package tn.esprit.formation.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.formation.entity.Materiel;
import tn.esprit.formation.entity.Session;

import java.util.List;

@Repository
public interface MaterielRepository extends JpaRepository<Materiel,Long> {

    List<Materiel> findBySession(Session session);
}
