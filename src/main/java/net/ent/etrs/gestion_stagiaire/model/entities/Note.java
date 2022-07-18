package net.ent.etrs.gestion_stagiaire.model.entities;

import lombok.Getter;
import lombok.Setter;
import net.ent.etrs.gestion_stagiaire.model.entities.references.Cmodel;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.time.LocalDate;


public class Note extends AbstractEntity {

    @Getter
    @Setter
    @NotNull(message = Cmodel.BV_NOTE_EVALUATION_NOT_NULL)
    @Valid
    private Evaluation evaluation;

    @Getter
    @Setter
    @PositiveOrZero(message = Cmodel.BV_NOTE_VALEUR_POSITIVE_OR_ZERO)
    private Double valeur;

    @Getter
    @Setter
    @NotNull(message = Cmodel.BV_NOTE_FORMATEUR_NOT_NULL)
    @Valid
    private Formateur formateur;

    @Getter
    @Setter
//    @Convert(converter = LocalDateConverter.class)
    @NotNull(message = Cmodel.BV_NOTE_DATE_NOT_NULL)
    private LocalDate dateNote;

}
