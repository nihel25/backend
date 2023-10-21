package tn.esprit.formation.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("recruteur")
@SuperBuilder
public class Recruteur extends User{
    private String specialite;

}
