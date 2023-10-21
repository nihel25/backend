package tn.esprit.formation.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.formation.DTO.UserDTO;
import tn.esprit.formation.Service.UserServiceimpl;
import tn.esprit.formation.entity.User;
import tn.esprit.formation.entity.UserRole;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/user")
public class UserController {


    @Autowired
   private UserServiceimpl service;

//    @GetMapping(value = "/{id}")
//    public ResponseEntity<User> findById(@PathVariable Long id) {
//        return ResponseEntity.ok().body(service.findById(id));
//
//    }


    @GetMapping("/getcoordinateurformationid")
    public Long getCoordinateurFormationId() {
        List<User> coordinateurFormations = service.getUsersByUserRole(UserRole.coordinateurformation);
        if (!coordinateurFormations.isEmpty()) {
            return coordinateurFormations.get(0).getId(); // Assuming there's only one coordinateurformation
        }
        return null;
    }
    @GetMapping("/coordinateurformationusers")
    public ResponseEntity<List<UserDTO>> getCoordinatorFormationUsers() {
        List<UserDTO> coordinatorFormationDTOs = service.getCoordinatorFormationUsers();
        return ResponseEntity.ok(coordinatorFormationDTOs);
    }
}