package tn.esprit.formation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.formation.entity.Specialitee;


@Repository
public interface specialiteeRepository extends JpaRepository<Specialitee,Long> {
}
