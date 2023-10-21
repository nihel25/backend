package tn.esprit.formation.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.formation.entity.Attestation;

@Repository
public interface AttestationRepository extends JpaRepository<Attestation,Long> {
}
