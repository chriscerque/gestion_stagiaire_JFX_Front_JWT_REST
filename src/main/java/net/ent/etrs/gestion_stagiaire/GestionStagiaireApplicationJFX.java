package net.ent.etrs.gestion_stagiaire;

import javafx.application.Application;
import javafx.scene.Parent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class GestionStagiaireApplicationJFX  /*extends Application*/ {

//	@Autowired
//	FxmlControllerFactory fxmlControllerFactory;

    @Autowired
    private ConfigurableApplicationContext springContext;

    private Parent root;

//	@PersistenceContext
//	private static EntityManager em1;

    public static void main(String[] args) {
        try {

//			Properties pros = System.getProperties();
//			pros.list(System.out);
//
//			Locale locale = new Locale(System.getProperty("user.language"), System.getProperty("user.country"));
//			ResourceBundle resourceBundle = ResourceBundle.getBundle("messages", locale);
//			System.out.println(resourceBundle.getString("hello"));


//			EntityManager em = Persistence.createEntityManagerFactory("PU_CREATE").createEntityManager();
//		EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
////		System.out.println(">>>>>>>>>>>>>>>>>>> em1 : " + em1);
//			System.out.println(">>>>>>>>>>>>>>>>>>> em : " + em);
            Application.launch(ChartApplication.class, args);
//			Application.launch(GestionStagiaireApplicationJFX.class, args);
//			launch(args);
            SpringApplication.run(GestionStagiaireApplicationJFX.class, args);

            System.out.println("GestionStagiaireApplication fin§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§");


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

//	@Override
//	public void init() throws Exception {
//		springContext = SpringApplication.run(GestionStagiaireApplicationJFX.class);
//		springContext.getAutowireCapableBeanFactory().autowireBean(this);
//	}

    //	@Override
//	public void init() throws Exception {
//		System.out.println(">>>>>>>>>>>>>>GestionStagiaireApplicationJFX/init");
//		springContext = new SpringApplicationBuilder(GestionStagiaireApplicationJFX.class).run();
//		try {
////            root = FXMLLoader.load(this.getClass().getResource(Screens.CONNEXION));
//
//			FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource(Screens.CONNEXION));
//			fxmlLoader.setControllerFactory(fxmlControllerFactory);
//			root = fxmlLoader.load();
//		} catch (IOException e) {
//			AlerteUtils.afficherMessageDansAlerte("une erreure est survenue lors du chargement de l'application.", Alert.AlertType.ERROR);
//			this.stop();
//		}
//	}

//	@Override
//	public void stop() {
//		System.out.println("SOrtie de l'application");
//		springContext.close();
//		Platform.exit();
//	}

//	/**
//	 * The main entry point for all JavaFX applications.
//	 * The start method is called after the init method has returned,
//	 * and after the system is ready for the application to begin running.
//	 *
//	 * <p>
//	 * NOTE: This method is called on the JavaFX Application Thread.
//	 * </p>
//	 *
//	 * @param primaryStage the primary stage for this application, onto which
//	 *                     the application scene can be set.
//	 *                     Applications may create other stages, if needed, but they will not be
//	 *                     primary stages.
//	 * @throws Exception if something goes wrong
//	 */
//	@Override
//	public void start(Stage primaryStage) throws Exception {
//
//		springContext.publishEvent(new StageReadyEvent(primaryStage));
//		primaryStage.setTitle("Gestion des stagiaires");
//
//		Scene scene = new Scene(root);
//		primaryStage.setScene(scene);
//		primaryStage.show();
//	}

//	static class StageReadyEvent extends ApplicationEvent {
//		public StageReadyEvent(Stage stage) {
//			super(stage);
//		}
//		public Stage getStage() {
//			return ((Stage) getSource());
//		}
//	}
}
