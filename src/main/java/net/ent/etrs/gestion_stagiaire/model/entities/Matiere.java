package net.ent.etrs.gestion_stagiaire.model.entities;


import lombok.Getter;
import lombok.Setter;
import net.ent.etrs.gestion_stagiaire.model.entities.references.Cmodel;

import javax.validation.constraints.NotEmpty;

public class Matiere extends AbstractEntity {

    @Getter
    @Setter
    @NotEmpty(message = Cmodel.BV_MATIERE_LIBELLE_NOT_NULL_NOT_EMPTY)
    private String nom;

}
