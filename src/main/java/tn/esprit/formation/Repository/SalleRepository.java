package tn.esprit.formation.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.formation.entity.Salle;

@Repository
public  interface SalleRepository extends JpaRepository<Salle,Long> {
}
