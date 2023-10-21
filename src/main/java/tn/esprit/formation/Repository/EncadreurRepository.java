package tn.esprit.formation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.formation.entity.Encadreur;

@Repository
public interface EncadreurRepository  extends JpaRepository<Encadreur, Long> {
}
