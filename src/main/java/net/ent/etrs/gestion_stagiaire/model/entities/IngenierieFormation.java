package net.ent.etrs.gestion_stagiaire.model.entities;

import lombok.Getter;
import lombok.Setter;
import net.ent.etrs.gestion_stagiaire.model.entities.references.TypeIF;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Set;

public class IngenierieFormation extends AbstractEntity {

    Set<UniteValeur> uvSet;
    @Getter
    @Setter
    private String libelle;
    @Getter
    @Setter
    private TypeIF typeIF;
    @Getter
    @Setter
//    @Convert(converter = LocalDateConverter.class)
    private LocalDate dateDebut;
    @Getter
    @Setter
//    @Convert(converter = LocalDateConverter.class)
    private LocalDate dateFin;

    public Set<UniteValeur> getUvSet() {
        return Collections.unmodifiableSet(this.uvSet);
    }

    public void setUvSet(Set<UniteValeur> uvSet) {
        this.uvSet = uvSet;
    }
}
