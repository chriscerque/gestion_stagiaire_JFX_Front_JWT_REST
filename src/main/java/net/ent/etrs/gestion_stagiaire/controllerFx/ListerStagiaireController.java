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
import net.ent.etrs.gestion_stagiaire.view.converter.AppartenanceConverter;
import net.ent.etrs.gestion_stagiaire.view.converter.GradeConverter;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

//@Component
public class ListerStagiaireController extends AbstractController {

    private static final String url = "http://127.0.0.1:8080/Stagiaires";


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






        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set(HttpHeaders.AUTHORIZATION, "Bearer " + AbstractController.getUserEnCours().getToken());
        RequestEntity<List<Stagiaire>> reqEntity = new RequestEntity<List<Stagiaire>>(new ArrayList<Stagiaire>(), headers, HttpMethod.GET, URI.create(url));
//        (headers, HttpMethod.GET, url);
        ParameterizedTypeReference<List<Stagiaire>> typeRef = new ParameterizedTypeReference<List<Stagiaire>>() {};



        RestTemplate restTemplate = new RestTemplate();
//        restTemplate.setMessageConverters(messageConverters);
        ResponseEntity<List<Stagiaire>> resEntity = restTemplate.exchange(reqEntity, typeRef);

        System.out.println(resEntity.getStatusCodeValue());
        for (Stagiaire b : resEntity.getBody()) {
            System.out.println(b);
        }

        //--------------------------------------------------------------------------------------------------------------------//
        this.olstStagiaires.addAll(resEntity.getBody());

        this.tcGrade.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getGrade()));
        this.tcGrade.setCellFactory(a -> new TextFieldTableCell<>(new GradeConverter()));
        this.tcNom.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getNom()));
        this.tcPrenom.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getPrenom()));
        this.tcAppartenance.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getAppartenance()));
        this.tcAppartenance.setCellFactory(a -> new TextFieldTableCell<>(new AppartenanceConverter()));

        this.tvStagiaires.setItems(olstStagiaires);
    }
}
