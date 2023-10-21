package tn.esprit.formation.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import tn.esprit.formation.AuthRequestResponse.RegistrationRequest;
import tn.esprit.formation.entity.CoordinateurFormation;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class CoordinateurFormationDTO extends RegistrationRequest {

 @NotNull
    private String Fonction;




    public static CoordinateurFormation toEntity(CoordinateurFormationDTO request) {
        return CoordinateurFormation.builder()
                .fullname(request.getFullname())
                .email(request.getEmail())
                .password(request.getPassword())
                .adresse(request.getAdresse())
                .telephone(request.getTelephone())
                .cin(request.getCin())
                .prenom(request.getPrenom())
                .Fonction(request.getFonction())
                .build();
    }


//
//
//
//
}
//