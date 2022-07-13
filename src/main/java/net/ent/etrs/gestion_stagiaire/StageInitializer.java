package net.ent.etrs.gestion_stagiaire;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import net.ent.etrs.gestion_stagiaire.commonUtils.JfxUtils.FxmlControllerFactory;
import net.ent.etrs.gestion_stagiaire.view.AlerteUtils;
import net.ent.etrs.gestion_stagiaire.view.Screens;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class StageInitializer implements ApplicationListener<StageReadyEvent> {

    @Autowired
    private ConfigurableApplicationContext applicationContext;

    @Autowired
    FXMLLoader fxmlLoader;

    @Autowired
    FxmlControllerFactory fxmlControllerFactory;

    Parent root;


    public StageInitializer() {
        System.out.println(">>>>>>>>>>>>>>>>>>> StageInitializer/constructeur");
    }

    @Override
    public void onApplicationEvent(StageReadyEvent event) {
        try {
            System.out.println(">>>>>>>>>>>>>>>>>>> StageInitializer/onApplicationEvent");
//            System.out.println("&&&&&&&&&&&&&& avant liste beans | StageInitializer");
////        applicationContext.getBeanFactory().getBeanNamesIterator().forEachRemaining(t-> System.out.println(t));
//            applicationContext.getBeanFactory().getBeanNamesIterator().forEachRemaining(t-> System.out.println(t));
//            System.out.println("&&&&&&&&&&&&&& apres liste beans | StageInitializer");
            Stage stage = event.getStage();
            stage.setTitle("MiliBank");

            fxmlLoader.setLocation(this.getClass().getResource(Screens.CONNEXION));
//            System.out.println(">>> avant fxmlControllerFactory");
            fxmlLoader.setControllerFactory(fxmlControllerFactory);
//            System.out.println(">>> fxmlControllerFactory : " + fxmlControllerFactory);
//            System.out.println(">>> apres fxmlControllerFactory");

            root = fxmlLoader.load();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            AlerteUtils.afficherMessageDansAlerte("une erreure est survenue lors du chargement de l'application.", Alert.AlertType.ERROR);
        }
    }
}
