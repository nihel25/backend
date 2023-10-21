package tn.esprit.formation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.formation.entity.UserProfile;


@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile,Long> {
}
