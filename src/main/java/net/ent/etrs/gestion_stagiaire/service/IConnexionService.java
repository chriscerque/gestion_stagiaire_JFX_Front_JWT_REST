package net.ent.etrs.gestion_stagiaire.service;

import net.ent.etrs.gestion_stagiaire.model.entities.MyUser;

public interface IConnexionService {
    MyUser connexion(final String login, final String password);
}
