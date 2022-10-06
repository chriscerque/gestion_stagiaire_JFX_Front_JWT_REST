package net.ent.etrs.gestion_stagiaire.controllerFx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.*;
import net.ent.etrs.gestion_stagiaire.model.entities.Stage;
import net.ent.etrs.gestion_stagiaire.model.entities.Stagiaire;
import net.ent.etrs.gestion_stagiaire.model.entities.references.Appartenance;
import net.ent.etrs.gestion_stagiaire.model.entities.references.Grade;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//@Component
public class ListerStagiaireController extends AbstractController {

    private static final String url = "http://127.0.0.1:8080/stagiaires";


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


//        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(url);
//        UriComponents uriComponents = uriComponentsBuilder.build();
//        System.out.println("uriComponents.toString()" + uriComponents.toString());
//        uriComponents.getQueryParams().forEach((a,b)-> System.out.printf("a : %s | b : %s", a, b));

//        RestTemplate restTemplate = new RestTemplate();
//        URI url = new URI("http://localhost:" + port + "/foo?param=bar");
//        RequestEntity<Void> request = RequestEntity.post(url).build();
//        ResponseEntity<Void> response = new RestTemplate().exchange(request, Void.class);
//        assertEquals(HttpStatus.OK, response.getStatusCode());


//        // Request Header
//        HttpHeaders headers = new HttpHeaders();
//
        // Request Body
        MultiValueMap<String, String> parametersMap = new LinkedMultiValueMap<String, String>();
        parametersMap.add("username", super.userEnCours.getUsername());
        parametersMap.add("password", "");


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
        headers.set(HttpHeaders.AUTHORIZATION, "Bearer " + AbstractController.getUserEnCours().getToken());
        // Request Body
//        RequestEntity<List<Stagiaire>> requestEntity = RequestEntity.post(URI.create(url))
//                .accept(MediaType.APPLICATION_JSON)
//                .headers(headers).body(null);

//        // RestTemplate
//        RestTemplate restTemplate = new RestTemplate();
//
//        headers.set(HttpHeaders.AUTHORIZATION, "Bearer " + AbstractController.getUserEnCours().getToken());
//        System.out.println(">>>>>>> token : " + AbstractController.getUserEnCours().getToken());
//        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
//        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
//        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
//        messageConverters.add(converter);
//        restTemplate.setMessageConverters(messageConverters);
//        System.out.println("11111");
//        GenericType<List<Stage>> testGenericType = new GenericType<List<Stage>>() {
//        };
//        List<Stagiaire> lstStagiaire = Arrays.asList(restTemplate.getForObject(url, Stagiaire[].class));
//        lstStagiaire.forEach(System.out::println);
//        System.out.println("22222");


//        HttpHeaders headers = new HttpHeaders();
        HttpEntity<List<Stagiaire>> reqEntity = new HttpEntity<List<Stagiaire>>(headers);
//        (headers, HttpMethod.GET, url);


        ParameterizedTypeReference<List<Stagiaire>> typeRef = new ParameterizedTypeReference<List<Stagiaire>>() {
        };

        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        MappingJackson2XmlHttpMessageConverter converter = new MappingJackson2XmlHttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.APPLICATION_XML));
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.APPLICATION_JSON));
//        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.));
        messageConverters.add(converter);


        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setMessageConverters(messageConverters);
        ResponseEntity<List<Stagiaire>> resEntity = restTemplate.exchange(URI.create(url), HttpMethod.GET, reqEntity, typeRef);


        //

        System.out.println(resEntity.getStatusCodeValue());
        for (Stagiaire b : resEntity.getBody()) {
            System.out.println(b);
        }


//        this.olstStagiaires.addAll(lstStagiaire);
//
//        this.tcGrade.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getGrade()));
//        this.tcGrade.setCellFactory(a -> new TextFieldTableCell<>(new GradeConverter()));
//        this.tcNom.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getNom()));
//        this.tcPrenom.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getPrenom()));
//        this.tcAppartenance.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getAppartenance()));
//        this.tcAppartenance.setCellFactory(a -> new TextFieldTableCell<>(new AppartenanceConverter()));
//
//        this.tvStagiaires.setItems(olstStagiaires);
    }
}
