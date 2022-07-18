package net.ent.etrs.gestion_stagiaire.controllerFx;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import net.ent.etrs.gestion_stagiaire.service.ConnexionService;
import net.ent.etrs.gestion_stagiaire.service.IConnexionService;
import net.ent.etrs.gestion_stagiaire.view.Screens;

//@Component
//@Controller
public class ConnexionController extends AbstractController {


    @FXML
    private TextField tfLogin;

    @FXML
    private PasswordField tfPwd;

    @FXML
    private Button btnConnexion;

    private IConnexionService connexionService;


    //    @Autowired
    public ConnexionController() {
        super();
        System.out.println("ConnexionController/controller");
        this.connexionService = new ConnexionService();
//        this.initialize();
    }

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
    public void initialize() {
//        System.out.println("ConnexionController/initialize");
        this.btnConnexion.setDisable(true);
        this.tfLogin.textProperty().addListener((obs, oldValue, newValue) -> gererBtnConnexion(newValue));
        this.tfPwd.textProperty().addListener((obs, oldValue, newValue) -> gererBtnConnexion(newValue));
        //TODO a retirer
        this.tfLogin.setText("ADMIN");
        this.tfPwd.setText("ADMIN");

    }

    private void gererBtnConnexion(String newValue) {
//        System.out.println("<<<<<<< ConnexionController/gererBtnConnexion");
        this.btnConnexion.onKeyPressedProperty().addListener((obs, oldV, newV) -> connexion());
        if (this.tfLogin.getText().trim().isEmpty() || this.tfPwd.getText().trim().isEmpty()) {
            this.btnConnexion.setDisable(true);
        } else {
            this.btnConnexion.setDisable(false);
        }
//        this.btnConnexion.setOnAction(this::connexion);
    }

    @FXML
    public void connexion() {
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

        this.connexionService.connexion(this.tfLogin.getText(), this.tfPwd.getText());

        chargerScene(this.btnConnexion.getScene(), Screens.ACCUEIL, null);
//        } catch (BusinessException e) {
//            AlerteUtils.afficherExceptionDansAlerte(e, Alert.AlertType.WARNING);
//        }
    }

}
