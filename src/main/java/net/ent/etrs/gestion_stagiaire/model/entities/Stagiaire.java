package net.ent.etrs.gestion_stagiaire.model.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.ent.etrs.gestion_stagiaire.model.entities.references.Appartenance;
import net.ent.etrs.gestion_stagiaire.model.entities.references.Cmodel;
import net.ent.etrs.gestion_stagiaire.model.entities.references.Grade;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@ToString(exclude = "noteList")
public class Stagiaire extends AbstractEntity {

    @Getter
    @Setter
    @NotBlank(message = Cmodel.BV_STAGIAIRE_NOM_NOT_NULL)
    private String nom;

    @Getter
    @Setter
    @NotBlank(message = Cmodel.BV_STAGIAIRE_PRENOM_NOT_NULL)
    private String prenom;

    @Getter
    @Setter
    @NotNull(message = Cmodel.BV_STAGIAIRE_GRADE_NOT_NULL)
    private Grade grade;

    @Getter
    @Setter
//    @NotNull(message = Cmodel.BV_STAGIAIRE_APPARTENANCE_NOT_NULL)
    private Appartenance appartenance;

    @Getter
    @Setter
//    @NotNull(message = Cmodel.BV_STAGIAIRE_DATE_NAISSANCE_NOT_NULL)
    @Past(message = Cmodel.BV_STAGIAIRE_DATE_NAISSANCE_PAST)
    private LocalDate dateNaissance;

    @Getter
    @Setter
    @Pattern(regexp = Cmodel.STAGIAIRE_PATTERN_MATRICULE)
    private String matricule;

    @Getter
    @Setter
    @Pattern(regexp = Cmodel.STAGIAIRE_PATTERN_NID)
    private String nid;

    @Getter
    @Setter
    private Integer numBatiment;

    @Getter
    @Setter
    private Integer numChambre;

    @Getter
    @Setter
    private Integer numBadgeMess;

    @Getter
    @Setter
    private Integer numBadgeAcces;

    private Set<Note> noteList = new HashSet<>();

    public void ajouterNote(@Valid Note note) {
        this.noteList.add(note);
    }

    public void supprimerNote(@Valid Note note) {
        this.noteList.remove(note);
    }
}
