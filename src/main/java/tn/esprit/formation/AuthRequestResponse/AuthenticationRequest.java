package tn.esprit.formation.AuthRequestResponse;


import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthenticationRequest {

    private String email;

    private String password;

}