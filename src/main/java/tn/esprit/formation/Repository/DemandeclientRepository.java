package tn.esprit.formation.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.formation.entity.Demandeclient;

@Repository
public interface DemandeclientRepository extends JpaRepository<Demandeclient , Long> {
}
