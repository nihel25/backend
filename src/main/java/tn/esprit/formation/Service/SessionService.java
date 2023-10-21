package tn.esprit.formation.Service;

import tn.esprit.formation.DTO.SessionDTO;
import tn.esprit.formation.entity.Personnel;
import tn.esprit.formation.entity.Session;

import java.util.Date;
import java.util.List;

public interface SessionService {

    void delete(Long id);

    List<SessionDTO> findAllSession();
    List<SessionDTO> findbydate(Date start , Date end);
    public List<Personnel> getAllPersonnel();

    public void savee(Session session);
    SessionDTO recherch(Long id);
}
