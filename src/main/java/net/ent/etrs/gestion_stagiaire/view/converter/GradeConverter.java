package net.ent.etrs.gestion_stagiaire.view.converter;

import javafx.util.StringConverter;
import net.ent.etrs.gestion_stagiaire.model.entities.references.Grade;

public class GradeConverter extends StringConverter<Grade> {
    @Override
    public String toString(Grade grd) {
        return grd == null ? "grade XXX" : grd.name();
    }

    @Override
    public Grade fromString(String string) {
        return null;
    }
}
