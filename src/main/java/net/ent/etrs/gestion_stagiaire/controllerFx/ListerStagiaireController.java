package net.ent.etrs.gestion_stagiaire.controllerFx;

import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import net.ent.etrs.gestion_stagiaire.model.entities.Stage;
import net.ent.etrs.gestion_stagiaire.model.entities.Stagiaire;
import net.ent.etrs.gestion_stagiaire.model.entities.references.Appartenance;
import net.ent.etrs.gestion_stagiaire.model.entities.references.Grade;
import net.ent.etrs.gestion_stagiaire.service.IStagiaireService;
import net.ent.etrs.gestion_stagiaire.service.StagiaireService;
import net.ent.etrs.gestion_stagiaire.view.converter.AppartenanceConverter;
import net.ent.etrs.gestion_stagiaire.view.converter.GradeConverter;

//@Component
public class ListerStagiaireController extends AbstractController {

    private IStagiaireService stagiaireService;
    @FXML
    private Parent barreMenu;

    @FXML
    private TableView<Stagiaire> tvStagiaires;

    @FXML
    private TableColumn<Stagiaire, Grade> tcGrade;

    @FXML
    private TableColumn<Stagiaire, String> tcNom;

    @FXML
    private TableColumn<Stagiaire, String> tcPrenom;

    @FXML
    private TableColumn<Stagiaire, Appartenance> tcAppartenance;

    @FXML
    private Button btnImportStagiairesCsv;

    @FXML
    private ComboBox<Stage> cbxStage;

    @FXML
    private TextField tfRechercheStage;

    private ObservableList<Stagiaire> olstStagiaires = FXCollections.observableArrayList();


    public void initialize() {

        this.stagiaireService = new StagiaireService();


        //--------------------------------------------------------------------------------------------------------------------//
        this.olstStagiaires.clear();
        this.olstStagiaires.addAll(stagiaireService.getAllStagiaires());

        this.tcGrade.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getGrade()));
        this.tcGrade.setCellFactory(a -> new TextFieldTableCell<>(new GradeConverter()));
        this.tcNom.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getNom()));
        this.tcPrenom.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getPrenom()));
        this.tcAppartenance.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getAppartenance()));
        this.tcAppartenance.setCellFactory(a -> new TextFieldTableCell<>(new AppartenanceConverter()));

        this.tvStagiaires.setItems(olstStagiaires);
    }
}
