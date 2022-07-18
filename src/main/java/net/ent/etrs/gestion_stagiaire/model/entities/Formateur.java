package net.ent.etrs.gestion_stagiaire.model.entities;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.ent.etrs.gestion_stagiaire.model.entities.references.Grade;

@ToString
public class Formateur extends AbstractEntity {

    @Getter
    @Setter
    private String nom;

    @Getter
    @Setter
    private String prenom;

    @Getter
    @Setter
    private Grade grade;

}
