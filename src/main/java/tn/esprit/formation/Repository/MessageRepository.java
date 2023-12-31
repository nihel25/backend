package tn.esprit.formation.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.formation.entity.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message,Long> {

    Message findByQuestion(String question);
}
