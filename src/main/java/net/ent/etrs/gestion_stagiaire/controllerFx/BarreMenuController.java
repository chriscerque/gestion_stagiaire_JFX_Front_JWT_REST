package net.ent.etrs.gestion_stagiaire.controllerFx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.VBox;
import net.ent.etrs.gestion_stagiaire.view.ClickableMenu;
import net.ent.etrs.gestion_stagiaire.view.Screens;

//@Component
public class BarreMenuController extends AbstractController {
	
	@FXML
	private VBox barreMenuRoot;

	@FXML
	private MenuBar barreMenu;


	@FXML
	public void initialize(){
		ClickableMenu clickableMenu =new ClickableMenu("Deconnexion");
		clickableMenu.setOnAction(e->this.deconnexion(new ActionEvent()));
		this.barreMenu.getMenus().add(this.barreMenu.getMenus().size()-1, clickableMenu);
	}
	
	@FXML
	public void gererStage(ActionEvent actionEvent) {
			chargerScene(this.barreMenu.getScene(), Screens.GERER_STAGE, null);
	}
	@FXML
	public void listerStages(ActionEvent actionEvent) {
		chargerScene(this.barreMenu.getScene(), Screens.LISTER_STAGE, null);
	}

	@FXML
	public void gererStagiaire(ActionEvent actionEvent) {
			chargerScene(this.barreMenu.getScene(), Screens.GERER_STAGIAIRE, null);
	}

	@FXML
	public void listerStagiaires(ActionEvent actionEvent) {
		chargerScene(this.barreMenu.getScene(), Screens.LISTER_STAGIAIRE, null);
	}
	
	@FXML
	public void deconnexion(ActionEvent actionEvent) {
//		super.setClientEnCours(null);
		chargerScene(this.barreMenu.getScene(), Screens.CONNEXION, null);
	}
	
	@FXML
	public void quitter(ActionEvent actionEvent) {
		super.quitter();
	}
	
}
