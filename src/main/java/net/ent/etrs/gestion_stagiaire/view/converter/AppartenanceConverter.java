package net.ent.etrs.gestion_stagiaire.view.converter;

import javafx.util.StringConverter;
import net.ent.etrs.gestion_stagiaire.model.entities.references.Appartenance;

public class AppartenanceConverter extends StringConverter<Appartenance> {
    @Override
    public String toString(Appartenance app) {
        return app == null ? "appartenance XXX" : app.name();
    }

    @Override
    public Appartenance fromString(String s) {
        return null;
    }
}
