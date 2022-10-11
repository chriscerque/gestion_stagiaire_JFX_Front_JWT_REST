package net.ent.etrs.gestion_stagiaire.controllerFx;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import net.ent.etrs.gestion_stagiaire.commonUtils.JfxUtils.FxmlControllerFactory;
import net.ent.etrs.gestion_stagiaire.model.entities.MyUser;
import net.ent.etrs.gestion_stagiaire.model.facade.IGradeFacade;
import net.ent.etrs.gestion_stagiaire.model.facade.IStagiaireFacade;
import net.ent.etrs.gestion_stagiaire.view.AlerteUtils;
import net.ent.etrs.gestion_stagiaire.view.Cview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;
import java.util.Objects;


//@Component
//@Scope("singleton")
public abstract class AbstractController {

    @Getter(AccessLevel.PROTECTED)
    @Setter(AccessLevel.PROTECTED)
    public static MyUser userEnCours;
    @Autowired
    protected IGradeFacade gradeFacade;
    //	@Autowired
//	AuthenticationProvider authenticationProvider;
    @Autowired
    protected IStagiaireFacade stagiaireFacade;
    @Autowired
    FXMLLoader loader;
    @Autowired
    private ConfigurableApplicationContext springContext;
    private AbstractController abstractController;
    @Autowired
    private FxmlControllerFactory fxmlControllerFactory;

//	public AbstractController() {
//		System.out.println("$$$$$$$ AbstractController/constructor sans param");
//	}

//	@PostConstruct
//	public void afficherEtat(){
//		System.out.println("$$$$$$$>>>>> >>>>> >>>>> FxmlControllerFactory : " + fxmlControllerFactory);
//		System.out.println("$$$$$$$>>>>> >>>>> >>>>> IGradeFacade : " + gradeFacade);
//		System.out.println("$$$$$$$>>>>> >>>>> >>>>> IStagiaireFacade : " + stagiaireFacade);
//	}


    public AbstractController(/*FxmlControllerFactory fxmlControllerFactory, IGradeFacade gradeFacade, IStagiaireFacade stagiaireFacade, FXMLLoader loader*/) {
//		System.out.println("$$$$$$$ AbstractController/constructor");

//		if(Objects.isNull(this.abstractController)){
//			abstractController = new AbstractController();
//		}

//		System.out.println("$$$$$$$>>>>> AbstractController : " + this);
//
//		System.out.println("$$$$$$$>>>>> >>>>> FxmlControllerFactory : " + fxmlControllerFactory);
//		System.out.println("$$$$$$$>>>>> >>>>> IGradeFacade : " + gradeFacade);
//		System.out.println("$$$$$$$>>>>> >>>>> IStagiaireFacade : " + stagiaireFacade);

//		this.fxmlControllerFactory = fxmlControllerFactory;
//		this.gradeFacade = gradeFacade;
//		this.stagiaireFacade = stagiaireFacade;
//		this.loader = loader;
//
//		System.out.println("$$$$$$$>>>>> >>>>> FxmlControllerFactory ****************: " + fxmlControllerFactory);
//		System.out.println("$$$$$$$>>>>> >>>>> IGradeFacade ****************: " + gradeFacade);
//		System.out.println("$$$$$$$>>>>> >>>>> IStagiaireFacade ****************: " + stagiaireFacade);

    }

    /**
     * Permet de charger une page fxml dans une scene en spécifiant le controller.
     *
     * @param sceneCourante
     * @param screen        page fxml
     * @param controller
     * @throws IOException
     */
    protected void chargerScene(Scene sceneCourante, String screen, Object controller) {
//		loader = new FXMLLoader(getClass().getResource(screen));
        loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(screen));
//		System.out.println("**************** chargerScene");
//		System.out.println("****************>>>>> fxmlControllerFactory : " + fxmlControllerFactory);
        loader.setControllerFactory(fxmlControllerFactory);
        if (!Objects.isNull(controller)) {
            loader.setController(controller);
        }
        try {
            sceneCourante.setRoot(loader.load());
        } catch (IOException e) {
            e.printStackTrace();
            AlerteUtils.afficherMessageDansAlerte("Une erreure s'est produite lors du chargement de la page.", AlertType.ERROR);
        }
    }

    protected void quitter() {
        boolean sortie = AlerteUtils.afficherMessageDansAlerte(Cview.CONFIRMATION_DIALOG, Cview.CONFIRMATION,
                Cview.CONFIRMATION_QUITTER, AlertType.CONFIRMATION);

        if (sortie) {
            System.out.println("Sortie de l'application...");
            springContext.close();
            Platform.exit();

        }
    }

    public void aPropos() {
        AlerteUtils.afficherMessageDansAlerte("Information Dialog", "Copyright", "Made by warti", AlertType.INFORMATION);
    }

}
