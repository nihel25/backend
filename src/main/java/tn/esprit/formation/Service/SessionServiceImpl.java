package tn.esprit.formation.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.formation.DTO.SessionDTO;
import tn.esprit.formation.Repository.*;
import tn.esprit.formation.entity.Personnel;
import tn.esprit.formation.entity.Session;
import tn.esprit.formation.validations.ObjectsValidator;

import javax.persistence.EntityNotFoundException;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SessionServiceImpl implements SessionService {

    @Autowired
    SessionRepository sessionRepository;
    @Autowired
    FormationRepository formationRepository;
    @Autowired
    SalleRepository salleRepository;
    @Autowired
    UserRepository userRepository;
    private final ObjectsValidator<SessionDTO> objectsValidator;
@Autowired
 PersonnelRepository personnelRepository;
    public SessionServiceImpl(ObjectsValidator<SessionDTO> objectsValidator) {
        this.objectsValidator = objectsValidator;
    }


    @Override
    public void delete(Long id) {
        Session salle = sessionRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id + " not found"));
        sessionRepository.deleteById(id);
    }


    @Override
    //
    public SessionDTO recherch(Long id) {
        Optional<Session> optionalsession =sessionRepository.findById(id);
        if (optionalsession.isPresent()) {
            Session session=optionalsession.get();
            return SessionDTO.fromentity(session);
        }
        else
        {
            return null;
        }}


    @Override
    public List<SessionDTO> findAllSession() {
        return sessionRepository.findAll()
                .stream()
                .map(SessionDTO::fromentity)
                .collect(Collectors.toList());
    }


    @Override
    public void savee(Session session) {

        sessionRepository.save(session);
    }

    @Override
    public List<Personnel> getAllPersonnel() {
        return personnelRepository.findAll();
    }
    @Override
    public List<SessionDTO> findbydate(Date start, Date end) {
        return null;
    }


    }

