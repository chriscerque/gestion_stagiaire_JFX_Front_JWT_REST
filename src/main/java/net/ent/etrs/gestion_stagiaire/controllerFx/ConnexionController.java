package net.ent.etrs.gestion_stagiaire.controllerFx;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import net.ent.etrs.gestion_stagiaire.commonUtils.JfxUtils.FxmlControllerFactory;
import net.ent.etrs.gestion_stagiaire.model.JwtRequest;
import net.ent.etrs.gestion_stagiaire.model.entities.MyUser;
import net.ent.etrs.gestion_stagiaire.model.entities.Stage;
import net.ent.etrs.gestion_stagiaire.model.entities.references.Role;
import net.ent.etrs.gestion_stagiaire.model.facade.IGradeFacade;
import net.ent.etrs.gestion_stagiaire.model.facade.IStagiaireFacade;
import net.ent.etrs.gestion_stagiaire.secu.AppAuthProvider;
import net.ent.etrs.gestion_stagiaire.view.Screens;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.context.support.BeanDefinitionDsl;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserCache;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//@Component
//@Controller
public class ConnexionController extends AbstractController {

    public static final String URL_LOGIN = "http://localhost:8080/authenticate";


    @FXML
    private TextField tfLogin;

    @FXML
    private PasswordField tfPwd;

    @FXML
    private Button btnConnexion;


////    @Autowired
//    public ConnexionController() {
//        super();
//        System.out.println("ConnexionController/controller");
////        this.initialize();
//    }

//    @Autowired
//    public ConnexionController(FxmlControllerFactory fxmlControllerFactory, IGradeFacade gradeFacade, IStagiaireFacade stagiaireFacade, FXMLLoader loader) {
//        super(fxmlControllerFactory, gradeFacade, stagiaireFacade, loader);
//    }

//    @FXML
//    @PostConstruct
//    private void toto(){
//        System.out.println("ConnexionController/PostConstruct");
//        System.out.println("tfLogin : " + tfLogin);
//        System.out.println("tfPwd : " + tfPwd);
//        System.out.println("btnConnexion : " + btnConnexion);
//    }


    @FXML
    public void initialize(){
//        System.out.println("ConnexionController/initialize");
        this.btnConnexion.setDisable(true);
        this.tfLogin.textProperty().addListener((obs,oldValue,newValue)->gererBtnConnexion(newValue));
        this.tfPwd.textProperty().addListener((obs,oldValue,newValue)->gererBtnConnexion(newValue));
        //TODO a retirer
        this.tfLogin.setText("admin");
        this.tfPwd.setText("ADMIN");

    }

    private void gererBtnConnexion(String newValue) {
//        System.out.println("<<<<<<< ConnexionController/gererBtnConnexion");
        this.btnConnexion.onKeyPressedProperty().addListener((obs, oldV, newV)->connexion());
        if(this.tfLogin.getText().trim().isEmpty() || this.tfPwd.getText().trim().isEmpty()){
            this.btnConnexion.setDisable(true);
        } else {
            this.btnConnexion.setDisable(false);
        }
//        this.btnConnexion.setOnAction(this::connexion);
    }

    @FXML
    public void connexion(){
        System.out.println("<<<<<<< ConnexionController/connexion");
//        try {
//        super.setUserEnCours(User.withDefaultPasswordEncoder().username(this.tfLogin.getText()).password("password").roles("USER").build());

//        super.setUserEnCours(User.withDefaultPasswordEncoder().username("user").password("password").roles("USER").build());



//        UsernamePasswordAuthenticationToken authReq
//                = new UsernamePasswordAuthenticationToken(this.tfLogin.getText(), this.tfPwd.getText());
//        Authentication auth = authenticationProvider.authenticate(authReq);
//        SecurityContext sc = SecurityContextHolder.getContext();
//        sc.setAuthentication(auth);
//
//
////        super.setUserEnCours(User.builder().username(this.tfLogin.getText()).password(this.tfPwd.getText()).roles("USER").build());
//
//            MyUser u = new MyUser();
//            u.setUsername(sc.getAuthentication().getName());
//            u.setPassword(sc.getAuthentication().getCredentials().toString());
//            sc.getAuthentication().getAuthorities().forEach(a->u.grantAuthority(Role.valueOf(a.getAuthority())));
//            super.setUserEnCours(u);
//        System.out.println("####### userName : " + super.getUserEnCours().getUsername());
//        System.out.println("####### pwd : " + super.getUserEnCours().getPassword());



        // Request Header
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        // Request Body
//        MultiValueMap<String, String> parametersMap = new LinkedMultiValueMap<String, String>();
//        parametersMap.add("username", this.tfLogin.getText());
//        parametersMap.add("password", this.tfPwd.getText());
//
//        System.out.println("parametersMap : " + parametersMap);
//
//        JSONObject jsonObject = new JSONObject();
//        try {
//            jsonObject.put("username", this.tfLogin.getText());
//            jsonObject.put("password", this.tfPwd.getText());
//        } catch (JSONException e) {
//            e.printStackTrace();
//            throw new RuntimeException(e);
//        }



        ParameterizedTypeReference<JwtRequest> parametersMap = new ParameterizedTypeReference<JwtRequest>(){};

        JwtRequest jwtRequest = new JwtRequest(this.tfLogin.getText(), this.tfPwd.getText());


        // Request Entity
//        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(parametersMap, headers);
//        RequestEntity<MultiValueMap<String, String>> requestEntity = new RequestEntity<>(parametersMap,headers, HttpMethod.POST, URI.create(URL_LOGIN));
        RequestEntity<JwtRequest> requestEntity = RequestEntity.post(URI.create(URL_LOGIN))
                .accept(MediaType.APPLICATION_JSON)
                .headers(headers)
                .body(jwtRequest);

        // RestTemplate
        RestTemplate restTemplate = new RestTemplate();

//        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
//        MappingJackson2XmlHttpMessageConverter converter = new MappingJackson2XmlHttpMessageConverter();
//        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.APPLICATION_JSON));
//        messageConverters.add(converter);

//        restTemplate.setMessageConverters(messageConverters);

//         MyRequest body = null;
//  RequestEntity<MyRequest> request = RequestEntity
//                     .post("https://example.com/{foo}")
//      .accept(MediaType.APPLICATION_JSON)
//                     .body(body);
//  ResponseEntity&lt;MyResponse&gt; response = template.exchange(request, MyResponse.class);
//




        // POST Login
//        ResponseEntity<String> response = restTemplate.exchange(URL_LOGIN,
//                HttpMethod.POST, requestEntity, String.class);
        ResponseEntity<String> response = restTemplate.exchange(requestEntity, String.class);


        HttpHeaders responseHeaders = response.getHeaders();

        List<String> list = responseHeaders.get("Authorization");
//        return list == null || list.isEmpty() ? null : list.get(0);
        String authorizationString = list.get(0);
        System.out.println("Authorization String=" + authorizationString);


            chargerScene(this.btnConnexion.getScene(), Screens.ACCUEIL, null);
//        } catch (BusinessException e) {
//            AlerteUtils.afficherExceptionDansAlerte(e, Alert.AlertType.WARNING);
//        }
    }

}
