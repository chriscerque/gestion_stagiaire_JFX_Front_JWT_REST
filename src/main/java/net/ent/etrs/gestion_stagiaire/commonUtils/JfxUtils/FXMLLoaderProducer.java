package net.ent.etrs.gestion_stagiaire.commonUtils.JfxUtils;

import javafx.fxml.FXMLLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class FXMLLoaderProducer {
//
//	@Autowired
//	Instance<Object> instance;
//
//	@Bean
//	public FXMLLoader createLoader() {
//		FXMLLoader loader = new FXMLLoader();
//		loader.setControllerFactory(param-> instance.select(param).get());
//		return loader;
//	}

    @Autowired
    private ConfigurableApplicationContext appContext;

//    @Autowired
//    private ResourceBundle resourceBundle;

//    @Autowired
//	FXMLLoader loader;

    @Bean
    public FXMLLoader createLoader() {
//		System.out.println(">>>>>>>>>FXMLLoaderProducer/createLoader");
//		loader = new FXMLLoader();
        FXMLLoader loader = new FXMLLoader();
//		loader.setControllerFactory(appContext::getBean);
        loader.setControllerFactory(p -> appContext.getBean(p));
//		loader.setResources(resourceBundle);
//		System.out.println(">>>>>>>>> ***** loader : " + loader);
        return loader;
    }

}
