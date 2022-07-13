package net.ent.etrs.gestion_stagiaire;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import net.ent.etrs.gestion_stagiaire.commonUtils.JfxUtils.FXMLLoaderProducer;
import net.ent.etrs.gestion_stagiaire.commonUtils.JfxUtils.FxmlControllerFactory;
import net.ent.etrs.gestion_stagiaire.view.Screens;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

//@SpringBootApplication
public class GestionStagiaireApplicationJFXCaca extends Application{

	@Autowired
	FxmlControllerFactory fxmlControllerFactory;

	@Autowired
//	@Qualifier(value = "toutou")
	FXMLLoaderProducer fxmlLoaderProducer;

	@Autowired
	private ConfigurableApplicationContext springContext;

	private Parent root;

//	@PersistenceContext
//	private static EntityManager em1;

	@Override
	public void init() throws Exception {
		System.out.println("++++++++++++++++++ GestionStagiaireApplicationJFX/init");
		springContext = SpringApplication.run(GestionStagiaireApplicationJFXCaca.class);
//		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Screens.CONNEXION));
		FXMLLoader fx = fxmlLoaderProducer.createLoader();
		fx.setLocation(getClass().getResource(Screens.CONNEXION));
//		fxmlLoader.setControllerFactory(springContext::getBean);
		System.out.println("++++++++++++++++++ fxmlControllerFactory : " + fxmlControllerFactory);
		fx.setControllerFactory(fxmlControllerFactory);
		root = fx.load();
	}

	@Override
	public void start(Stage stage) throws Exception {
		stage.setScene(new Scene(root));
		stage.show();
	}

	@Override
	public void stop() throws Exception {
		springContext.close();
	}

	public static void main(String[] args) {
		try {

//			Properties pros = System.getProperties();
//			pros.list(System.out);
//
//			Locale locale = new Locale(System.getProperty("user.language"), System.getProperty("user.country"));
//			ResourceBundle resourceBundle = ResourceBundle.getBundle("messages", locale);
//			System.out.println(resourceBundle.getString("hello"));


//			EntityManager em = Persistence.createEntityManagerFactory("PU_CREATE").createEntityManager();
		EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
			System.out.println(">>>>>>>>>>>>>>>>>>> em : " + em);
			Application.launch(args);

		}catch (Exception e){
			e.printStackTrace();
		}

	}


}
