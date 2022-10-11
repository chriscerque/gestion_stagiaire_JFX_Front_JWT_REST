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
import net.ent.etrs.gestion_stagiaire.view.AlerteUtils;
import net.ent.etrs.gestion_stagiaire.view.converter.AppartenanceConverter;
import net.ent.etrs.gestion_stagiaire.view.converter.GradeConverter;
import org.springframework.beans.factory.annotation.Autowired;

//@Component
public class ListerStagiaireController extends AbstractController {


    @Autowired
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

        this.olstStagiaires.clear();
        try {
            this.olstStagiaires.addAll(stagiaireService.getAllStagiaires());
        } catch (Exception e) {
            AlerteUtils.afficherExceptionDansAlerte(e, Alert.AlertType.ERROR);
        }

        this.tcGrade.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getGrade()));
        this.tcGrade.setCellFactory(a -> new TextFieldTableCell<>(new GradeConverter()));
        this.tcNom.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getNom()));
        this.tcPrenom.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getPrenom()));
        this.tcAppartenance.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getAppartenance()));
        this.tcAppartenance.setCellFactory(a -> new TextFieldTableCell<>(new AppartenanceConverter()));

        this.tvStagiaires.setItems(olstStagiaires);
    }
}
