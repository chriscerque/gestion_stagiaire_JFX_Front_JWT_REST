package net.ent.etrs.gestion_stagiaire.controllerFx;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Configuration
public class JfxControllerProducer {

    @Bean(name = "GererStagiaireController")
    public static GererStagiaireController getGererStagiaireController(){
//        System.out.println("$$$$$$$ JfxControllerProducer/GererStagiaireController");
        return new GererStagiaireController();
    }

    @Bean(name = "BarreMenuController")
    public static BarreMenuController getBarreMenuController(){
//        System.out.println("$$$$$$$ JfxControllerProducer/BarreMenuController");
        return new BarreMenuController();
    }

    @Bean(name = "ConnexionController")
//    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public static ConnexionController getConnexionController(){
//        System.out.println("$$$$$$$ JfxControllerProducer/ConnexionController");
        return new ConnexionController();
    }

    @Bean(name = "ListerStagiaireController")
//    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public static ListerStagiaireController getListerStagiaireController(){
//        System.out.println("$$$$$$$ JfxControllerProducer/ListerStagiaireController");
        return new ListerStagiaireController();
    }

    @Bean(name = "AccueilController")
    public static AccueilController getAccueilController(){
//        System.out.println("$$$$$$$ JfxControllerProducer/AccueilController");
        return new AccueilController();
    }




}
