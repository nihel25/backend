package tn.esprit.formation.Service;

import tn.esprit.formation.AuthRequestResponse.AuthenticationRequest;
import tn.esprit.formation.AuthRequestResponse.AuthenticationResponse;
import tn.esprit.formation.AuthRequestResponse.RegistrationRequest;
import tn.esprit.formation.DTO.UserDTO;
import tn.esprit.formation.entity.User;

import java.util.List;

//
public interface UserService {
    User findById(Long id);
    void delete(Long id);
  AuthenticationResponse register(RegistrationRequest request);

    AuthenticationResponse authenticate(AuthenticationRequest request);
   // void createadmine();

    List<UserDTO> findAll();
    public Long getCurrentUserId();

    public UserDTO getCurrentUser();
//
}
