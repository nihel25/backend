package tn.esprit.formation.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.formation.entity.StoredFile;

@Repository
public interface StoredFileRepository extends JpaRepository<StoredFile,Long> {
}
