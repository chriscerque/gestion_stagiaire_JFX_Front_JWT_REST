package net.ent.etrs.gestion_stagiaire.service;

import net.ent.etrs.gestion_stagiaire.model.entities.Stagiaire;

import java.util.List;

public interface IStagiaireService {
    List<Stagiaire> getAllStagiaires() throws Exception;
}
