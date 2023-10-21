package tn.esprit.formation.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.formation.entity.Avis;

@Repository
public interface AvisRepository extends JpaRepository<Avis ,Long > {
}
