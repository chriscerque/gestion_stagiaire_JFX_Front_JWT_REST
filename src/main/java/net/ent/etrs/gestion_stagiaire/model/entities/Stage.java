package net.ent.etrs.gestion_stagiaire.model.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.ent.etrs.gestion_stagiaire.model.entities.references.Cmodel;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@EqualsAndHashCode(callSuper = false, of = "codeStage")
@ToString(exclude = "stagiaireList")
public class Stage extends AbstractEntity {

    @Getter
    @Setter
//    @NotNull(message = C_MODEL.BV_STAGE_IF_NOT_NULL)
    private IngenierieFormation ingenierieFormation;

    @Getter
    @Setter
    @NotBlank(message = Cmodel.BV_STAGE_CODE_STAGE_NOT_NULL)
    private String codeStage;

    @Getter
    @Setter
//    @Convert(converter = LocalDateConverter.class)
    @NotNull(message = Cmodel.BV_STAGE_DATE_DEBUT_NOT_NULL)
    private LocalDate dateDebut;

    @Getter
    @Setter
//    @Convert(converter = LocalDateConverter.class)
    @NotNull(message = Cmodel.BV_STAGE_DATE_FIN_NOT_NULL)
    private LocalDate dateFin;

    @Getter
    @Setter
    @NotNull(message = Cmodel.BV_STAGE_CDSF_NOT_NULL)
    private Formateur cdsf;


    private List<Stagiaire> stagiaireList = new ArrayList<>();

    public void addStagiaire(@Valid Stagiaire stagiaire) {
        this.stagiaireList.add(stagiaire);
    }

    public void supprStagiaire(@Valid Stagiaire stagiaire) {
        this.stagiaireList.remove(stagiaire);
    }

}
