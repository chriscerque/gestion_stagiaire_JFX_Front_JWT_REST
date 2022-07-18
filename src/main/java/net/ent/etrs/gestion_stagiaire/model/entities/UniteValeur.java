package net.ent.etrs.gestion_stagiaire.model.entities;

import lombok.Getter;
import lombok.Setter;
import net.ent.etrs.gestion_stagiaire.model.entities.references.Cmodel;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.util.Set;

public class UniteValeur extends AbstractEntity {

    Set<Evaluation> evaluationList;
    @Getter
    @Setter
    @NotNull(message = Cmodel.BV_UNITE_VALEUR_INDICE_NOT_NULL)
    @PositiveOrZero(message = Cmodel.BV_UNITE_VALEUR_INDICE_POSITIVE_OR_ZERO)
    private Integer indice;

    public void ajouterEvaluation(@Valid Evaluation evaluation) {
        this.evaluationList.add(evaluation);
    }

    public void supprimerEvaluation(@Valid Evaluation evaluation) {
        this.evaluationList.remove(evaluation);
    }


}
