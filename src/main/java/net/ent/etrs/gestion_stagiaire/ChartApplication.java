package net.ent.etrs.gestion_stagiaire;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import net.ent.etrs.gestion_stagiaire.commonUtils.JfxUtils.FxmlControllerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

//@SpringBootApplication
@Component
public class ChartApplication extends Application {
    
    @Autowired
    FxmlControllerFactory fxmlControllerFactory;

    @Autowired
    FXMLLoader fxmlLoader;
    
    private ConfigurableApplicationContext configurableApplicationContext;

//    private ApplicationContext applicationContext;

//    @Autowired
//    AnchorPane root;

    @Override
    public void init() {
        System.out.println(">>>>>>>> ChartApplication/init");
//        applicationContext = new SpringApplicationBuilder(GestionStagiaireApplicationJFX.class).run();
        configurableApplicationContext = new SpringApplicationBuilder(GestionStagiaireApplicationJFX.class).run();
//        try {
//            applicationContext = new SpringApplicationBuilder(GestionStagiaireApplicationJFX.class).beanNameGenerator(new BeanNameGenerator() {
//
//                @Override
//                public String generateBeanName(BeanDefinition definition, BeanDefinitionRegistry registry) {
//                    System.out.println("bean name : " + definition.getBeanClassName());
//                    if(registry.isBeanNameInUse(definition.getBeanClassName())){
//                        System.out.println(">>>>>>>>>>>>> bean all ready exist !!!!!!!!!!!");
//                        System.out.println("bean name : " + definition.getBeanClassName());
//                        try {
//                            throw new TotoException(definition.getBeanClassName());
//                        } catch (TotoException e) {
//                            System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
//                            System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
//                            System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
//                            System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
//                            System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
//                        }
////                        return definition.getBeanClassName().concat("2");
//                    }
//                    return definition.getBeanClassName();
//                }
//            }).run();
//        }catch (BeanCreationException e1){
//            System.err.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
//            System.err.println(e1.getMessage());
//        }

    }
    @Override
    public void start(Stage stage) {

//        System.out.println("&&&&&&&&&&&&&& avant liste beans");
//        applicationContext.getBeanFactory().getBeanNamesIterator().forEachRemaining(t-> System.out.println(t));
//        System.out.println("&&&&&&&&&&&&&& apres liste beans");
        configurableApplicationContext.publishEvent(new StageReadyEvent(stage));
//        System.out.println("&&&&&&&&&&&&&& avant liste beans");
//        applicationContext.getBeanFactory().getBeanNamesIterator().forEachRemaining(t-> System.out.println(t));
//        System.out.println("&&&&&&&&&&&&&& apres liste beans");
//        AnchorPane root = new AnchorPane();
//        Label label = new Label("hello !!!!");
//        root.getChildren().add(label);
//        Scene scene = new Scene(root,800,600);
//        stage.setScene(scene);
//        stage.setTitle("MiliBank");


//        AnchorPane root = null;
//        try {
////            root = FXMLLoader.load(this.getClass().getResource(Screens.CONNEXION));
//            URL uRL;
////            fxmlLoader = new FXMLLoader(this.getClass().getResource(Screens.CONNEXION));
//            fxmlLoader.setLocation(this.getClass().getResource(Screens.CONNEXION));
//            System.out.println(">>> avant fxmlControllerFactory");
//            fxmlLoader.setControllerFactory(fxmlControllerFactory);
//            System.out.println(">>> fxmlControllerFactory : " + fxmlControllerFactory);
//            System.out.println(">>> apres fxmlControllerFactory");
//            root = fxmlLoader.load();
//        } catch (IOException e) {
//            AlerteUtils.afficherMessageDansAlerte("une erreure est survenue lors du chargement de l'application.", Alert.AlertType.ERROR);
//            this.stop();
//        }
//
//
//        Scene scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();

    }
    @Override
    public void stop() {
        System.out.println("SOrtie de l'application");
        configurableApplicationContext.close();
        Platform.exit();
    }
//    static class StageReadyEvent extends ApplicationEvent {
//        public StageReadyEvent(Stage stage) {
//            super(stage);
//        }
//        public Stage getStage() {
//            return ((Stage) getSource());
//        }
//    }
}
