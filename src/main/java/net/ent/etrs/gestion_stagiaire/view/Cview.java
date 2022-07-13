package net.ent.etrs.gestion_stagiaire.view;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Cview {
	
	public static final String CONFIRMATION_DIALOG = "Quitter";
	public static final String CONFIRMATION = "Are you sure ???";
	public static final String CONFIRMATION_QUITTER = "Voulez-vous vraiment quitter l'application ???";

    public static final String PATTERN_FORMAT_DATE = "dd/MM/yyyy";
    public static final String ERREUR_CHARGEMENT_DETAILLER_COMPTE = "Une erreur est survenue lors du chargement des opérations du compte.";
	public static final String ERREUR_VIREMENT_FORMAT_MONTANT = "Le format du montant est incorrect.";
	public static final String ERREUR_VIREMENT = "Une erreure s'est produite lors de la création du virement.";
}
