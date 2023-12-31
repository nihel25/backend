package tn.esprit.formation.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Salle {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
private String nomsalle;
private Long nombreplace;
private Boolean statut;
    @OneToMany(mappedBy = "salle")
    @JsonIgnore
    private List<Session> sessions;


    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDebut;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateFin;

    public Salle(Long id, String nomsalle, Long nombreplace, Boolean statut) {
        this.id = id;
        this.nomsalle = nomsalle;
        this.nombreplace = nombreplace;
        this.statut = statut;
    }
}
