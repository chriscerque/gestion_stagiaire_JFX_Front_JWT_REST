package net.ent.etrs.gestion_stagiaire.controllerFx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import net.ent.etrs.gestion_stagiaire.commonUtils.JfxUtils.FxmlControllerFactory;
import net.ent.etrs.gestion_stagiaire.model.entities.EntitiesFactory;
import net.ent.etrs.gestion_stagiaire.model.entities.Stagiaire;
import net.ent.etrs.gestion_stagiaire.model.entities.references.Appartenance;
import net.ent.etrs.gestion_stagiaire.model.entities.references.Grade;
import net.ent.etrs.gestion_stagiaire.model.facade.FacadeFactory;
import net.ent.etrs.gestion_stagiaire.model.facade.IGradeFacade;
import net.ent.etrs.gestion_stagiaire.model.facade.IStagiaireFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

//@Component
public class GererStagiaireController /*extends AbstractController*/{

    @Autowired
    IStagiaireFacade stagiaireFacade;

    @Autowired
    IGradeFacade gradeFacade;

    @FXML
    TextField tfNom;

    @FXML
    TextField tfPrenom;

    @FXML
    ComboBox<Grade> cbxGrade;

    @FXML
    Button btnHebergement;

    @FXML
    Label lblNumBatiment;

    @FXML
    Label lblNumChambre;

    @FXML
    Button btnBadges;

    @FXML
    Label lblNumBadgeMess;

    @FXML
    Label lblNumBadgeAcces;

    @FXML
    TextField tfNID;

    @FXML
    TextField tfMatricule;

    @FXML
    ComboBox<Appartenance> cbxAppartenance;

    @FXML
    Button btnValider;

    @FXML
    DatePicker dpDateNaissance;

    ObservableList<Grade> gradeObservableList = FXCollections.observableArrayList();
    ObservableList<Appartenance> appartenanceObservableList = FXCollections.observableArrayList();

//    @Autowired
//    public GererStagiaireController(FxmlControllerFactory fxmlControllerFactory, IGradeFacade gradeFacade, IStagiaireFacade stagiaireFacade, FXMLLoader loader) {
//        super(fxmlControllerFactory, gradeFacade, stagiaireFacade, loader);
//    }

//    public GererStagiaireController() {
//        super();
//        System.out.println("GererStagiaireController/constructor sans param");
////        this.initialize();
//    }

    @FXML
    public void initialize(){
        chargerCbxGrade();
        chargerCbxAppartenance();

    }

    private void chargerCbxAppartenance() {
        this.appartenanceObservableList.addAll(Arrays.asList(Appartenance.values()));
        this.cbxAppartenance.setItems(this.appartenanceObservableList);
    }

    private void chargerCbxGrade() {
//        System.out.println("gradeFacade : " + gradeFacade);
//        this.gradeObservableList.addAll(FacadeFactory.getGradeFacade().readAllGrades());
        this.gradeObservableList.addAll(gradeFacade.readAllGrades());
        this.cbxGrade.setItems(this.gradeObservableList);
    }


    @FXML
    public void valider(){
        Stagiaire stagiaire = EntitiesFactory.fabriquerStagiaire(this.tfNom.getText(), this.tfPrenom.getText(), this.cbxGrade.getValue());
//        FacadeFactory.getStagaireFacade().saveStagiaire(stagiaire);
        stagiaire.setAppartenance(this.cbxAppartenance.getValue());
        stagiaireFacade.saveStagiaire(stagiaire);
    }

}
