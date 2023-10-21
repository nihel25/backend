package tn.esprit.formation.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.formation.entity.Certificat;

@Repository
public interface CertificatRepository extends JpaRepository<Certificat,Long> {
}
