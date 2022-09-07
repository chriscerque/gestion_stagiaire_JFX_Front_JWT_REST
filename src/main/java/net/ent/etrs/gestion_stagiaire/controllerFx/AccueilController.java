package net.ent.etrs.gestion_stagiaire.controllerFx;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Label;

//@Component
public class AccueilController extends AbstractController {

    @FXML
    private Parent barreMenu;
    //    @FXML
//    private TableView<Compte> tvComptesClient;
//    @FXML
//    private TableColumn<Compte, String> tcLibelle;
//    @FXML
//    private TableColumn<Compte, BigDecimal> tcSolde;
    @FXML
    private Label lblBonjour;


//    private ObservableList<Compte> olstComptesClient = FXCollections.observableArrayList();
//    private FilteredList<Compte> filteredListComptesClient = new FilteredList<>(olstComptesClient, s->true);
//    private SortedList<Compte> sortedLstComptesClient = new SortedList<>(filteredListComptesClient);

    @FXML
    public void initialize() {
        renseignerInfoClient();
//        chargerLstAuteur();
//        chargerTvComptesClient();


    }

    private void renseignerInfoClient() {
//        this.lblBonjour.setText(SecurityContextHolder.getContext().getAuthentication().getName());
        this.lblBonjour.setText(String.format("%s", super.getUserEnCours().getUsername()));
    }

//    private void chargerLstAuteur() {
//        this.olstComptesClient.clear();
//        List<Compte> lst = FACADE_COMPTE.findAllToClient(super.getClientEnCours());
//        this.olstComptesClient.addAll(lst);
//
//    }

//    private void chargerTvComptesClient() {
//        this.tcLibelle.setCellValueFactory(a->new SimpleObjectProperty<>(a.getValue().getLibelle()));
//        this.tcSolde.setCellValueFactory(a->new SimpleObjectProperty<>(a.getValue().getSolde()));
//
//        this.sortedLstComptesClient.comparatorProperty().bind(this.tvComptesClient.comparatorProperty());
//        this.tvComptesClient.setItems(sortedLstComptesClient);
//
//        ajouterContextMenuTvComptesClient();
//
//    }

//    private void ajouterRegleColorationSoldeTvComptesClient() {
//        this.tvComptesClient.
//    }

//    private void ajouterContextMenuTvComptesClient() {
//        tvComptesClient.setRowFactory(new Callback<TableView<Compte>, TableRow<Compte>>() {
//            @Override
//            public TableRow<Compte> call(TableView<Compte> param) {
//                TableRow<Compte> row = new TableRow<>();
//                row.emptyProperty().addListener((obs, wasEmpty, isEmpty) -> {
//                    if (isEmpty) {
//                        row.setContextMenu(null);
//                    } else {
//                        row.setContextMenu(creerContextMenu());
//                    }
//                });
////                row.itemProperty().addListener((obs, oldValue, newValue)->{
////                    if(newValue.getSolde().signum() <0 ){
////                        tcSolde.setCellValueFactory(a->a.getTableColumn().set);
////                    }
////                        });
//                return row;
//            }
//        });
//    }

//    private ContextMenu creerContextMenu() {
//        //création du menu contextuel
//        ContextMenu contextMenu = new ContextMenu();
//        // création du/des options du menu contextuel
//        MenuItem itemModifier = new MenuItem("Détail du compte");
//        MenuItem itemSupprimer = new MenuItem("Effectuer un virement");
//        //mappage de la méthode supprimer() sur le menuItem
//        itemModifier.setOnAction(event->detaillerCompte());
//        itemSupprimer.setOnAction(event->effectuerVirement());
//        //ajout du menuItem au contextMenu
//        contextMenu.getItems().add(itemModifier);
//        contextMenu.getItems().add(itemSupprimer);
//        return contextMenu;
//    }

//    private void effectuerVirement() {
//        chargerScene(this.barreMenu.getScene(), Screens.GERER_VIREMENT, null);
//    }

//    private void detaillerCompte() {
//        chargerScene(this.barreMenu.getScene(), Screens.DETAILLER_COMPTE, new DetaillerCompteController(this.tvComptesClient.getSelectionModel().getSelectedItem()));
//    }

}
