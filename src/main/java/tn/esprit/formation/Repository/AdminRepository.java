package tn.esprit.formation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.formation.entity.Admin;


@Repository
public interface AdminRepository extends JpaRepository<Admin,Long> {



    boolean existsByEmail(String email);
}
