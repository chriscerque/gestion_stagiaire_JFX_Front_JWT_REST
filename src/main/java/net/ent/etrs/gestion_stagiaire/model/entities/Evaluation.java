package net.ent.etrs.gestion_stagiaire.model.entities;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.ent.etrs.gestion_stagiaire.model.entities.references.Appartenance;
import net.ent.etrs.gestion_stagiaire.model.entities.references.Cmodel;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@NoArgsConstructor(access = AccessLevel.PUBLIC)

public class Evaluation extends AbstractEntity {

    @Getter
    @Setter
    @Min(value = 0, message = Cmodel.BV_EVALUATION_COEFF)
    private Integer coeff;

    @Getter
    @Setter
    @NotNull(message = Cmodel.BV_EVALUATION_TYPE_STAGIAIRE)
    @Valid
    private Appartenance typeStagiaire;

    @Getter
    @Setter
    @NotNull(message = Cmodel.BV_EVALUATION_MATIERE)
    private Matiere matiere;
}
