package tn.esprit.formation.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.formation.entity.User;
import tn.esprit.formation.entity.UserRole;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByprenom(String prenom);
    Optional<User> findByEmail(String email);




    List<User> findByRole(UserRole userRole);
}
