package net.ent.etrs.gestion_stagiaire.controllerFx;

import com.fasterxml.classmate.GenericType;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import net.ent.etrs.gestion_stagiaire.controller.StageController;
import net.ent.etrs.gestion_stagiaire.model.entities.Stage;
import net.ent.etrs.gestion_stagiaire.model.entities.Stagiaire;
import net.ent.etrs.gestion_stagiaire.model.entities.references.Appartenance;
import net.ent.etrs.gestion_stagiaire.model.entities.references.Grade;
import net.ent.etrs.gestion_stagiaire.view.converter.AppartenanceConverter;
import net.ent.etrs.gestion_stagiaire.view.converter.GradeConverter;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.awt.print.Book;
import java.net.URI;
import java.util.*;

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





    public void initialize(){

        
//        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(url);
//        UriComponents uriComponents = uriComponentsBuilder.build();
//        System.out.println("uriComponents.toString()" + uriComponents.toString());
//        uriComponents.getQueryParams().forEach((a,b)-> System.out.printf("a : %s | b : %s", a, b));

        RestTemplate restTemplate = new RestTemplate();
//        URI url = new URI("http://localhost:" + port + "/foo?param=bar");
//        RequestEntity<Void> request = RequestEntity.post(url).build();
//        ResponseEntity<Void> response = new RestTemplate().exchange(request, Void.class);
//        assertEquals(HttpStatus.OK, response.getStatusCode());


//        // Request Header
//        HttpHeaders headers = new HttpHeaders();
//
//        // Request Body
//        MultiValueMap<String, String> parametersMap = new LinkedMultiValueMap<String, String>();
//        parametersMap.add("username", super.userEnCours.getUsername());
//        parametersMap.add("password", super.userEnCours.getPassword());
//
//        // Request Entity
//        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(parametersMap, headers);
//
//        // RestTemplate
//        RestTemplate restTemplate = new RestTemplate();
//
//        // POST Login
//        ResponseEntity<String> response = restTemplate.exchange(URL_LOGIN, //
//                HttpMethod.POST, requestEntity, String.class);
//
//
//        HttpHeaders responseHeaders = response.getHeaders();
//
//        List<String> list = responseHeaders.get("Authorization");
////        return list == null || list.isEmpty() ? null : list.get(0);
//        String authorizationString = list.get(0);
//        System.out.println("Authorization String=" + authorizationString);



        // Request Header
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set(HttpHeaders.AUTHORIZATION, "Bearer "+);

        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
        messageConverters.add(converter);
        restTemplate.setMessageConverters(messageConverters);
        System.out.println("11111");
        GenericType<List<Stage>> testGenericType = new GenericType<List<Stage>>(){};
        List<Stagiaire> lstStagiaire = Arrays.asList(restTemplate.getForObject(url, Stagiaire[].class));
        lstStagiaire.forEach(System.out::println);
        System.out.println("22222");


        this.olstStagiaires.addAll(lstStagiaire);

        this.tcGrade.setCellValueFactory(param->new SimpleObjectProperty<>(param.getValue().getGrade()));
        this.tcGrade.setCellFactory(a->new TextFieldTableCell<>(new GradeConverter()));
        this.tcNom.setCellValueFactory(param->new SimpleObjectProperty<>(param.getValue().getNom()));
        this.tcPrenom.setCellValueFactory(param->new SimpleObjectProperty<>(param.getValue().getPrenom()));
        this.tcAppartenance.setCellValueFactory(param->new SimpleObjectProperty<>(param.getValue().getAppartenance()));
        this.tcAppartenance.setCellFactory(a->new TextFieldTableCell<>(new AppartenanceConverter()));

        this.tvStagiaires.setItems(olstStagiaires);


//        HttpHeaders headers = new HttpHeaders();
//        RequestEntity<List<Stage>> reqEntity = new RequestEntity<List<Stage>>(headers, HttpMethod.GET, URI.create(url));
////        (headers, HttpMethod.GET, url);
//        ParameterizedTypeReference<List<Stage>> typeRef = new ParameterizedTypeReference<List<Stage>>() {};
//
//        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
//        MappingJackson2XmlHttpMessageConverter converter = new MappingJackson2XmlHttpMessageConverter();
//        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.APPLICATION_XML));
//        messageConverters.add(converter);
//
//        RestTemplate restTemplate = new RestTemplate();
//        restTemplate.setMessageConverters(messageConverters);
//        ResponseEntity<List<Stage>> resEntity = restTemplate.exchange(reqEntity, typeRef);
//
//        System.out.println(resEntity.getStatusCodeValue());
//        for (Stage b : resEntity.getBody()) {
//            System.out.println(b);
//        }
    }
}
