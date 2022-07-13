package net.ent.etrs.gestion_stagiaire.commonUtils.JfxUtils;

import javafx.util.Callback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
//@Service
public class FxmlControllerFactory implements Callback<Class<?>, Object> {

    @Autowired
    private ApplicationContext appContext;

    @Override
    public Object call(Class<?> type) {
//        System.out.println(">>>>>>>>>FxmlControllerFactory/call");
//        System.out.println(">>>>>>>>> >>>>> type : " + type);
        try {

            Object controller = appContext.getBean(type);

//            System.out.println(">>>>>>>>> >>>>> controller : " + controller);
            return controller;
        }catch (Exception e){
            e.printStackTrace();
        }
        System.err.println("*******************>>>>>>>>>>>>>>>>>>>>>>>>#####################################");
        System.err.println("*******************>>>>>>>>>>>>>>>>>>>>>>>>#####################################");
        System.err.println("*******************>>>>>>>>>>>>>>>>>>>>>>>>#####################################");
        System.err.println("*******************>>>>>>>>>>>>>>>>>>>>>>>>#####################################");
        System.err.println("*******************>>>>>>>>>>>>>>>>>>>>>>>>#####################################");
        System.err.println("*******************>>>>>>>>>>>>>>>>>>>>>>>>#####################################");
        System.err.println("*******************>>>>>>>>>>>>>>>>>>>>>>>>#####################################");
        System.err.println("*******************>>>>>>>>>>>>>>>>>>>>>>>>#####################################");
        System.err.println("*******************>>>>>>>>>>>>>>>>>>>>>>>>#####################################");
        System.err.println("*******************>>>>>>>>>>>>>>>>>>>>>>>>#####################################");
        System.err.println("*******************>>>>>>>>>>>>>>>>>>>>>>>>#####################################");
        System.err.println("*******************>>>>>>>>>>>>>>>>>>>>>>>>#####################################");
        System.err.println("*******************>>>>>>>>>>>>>>>>>>>>>>>>#####################################");
        System.err.println("*******************>>>>>>>>>>>>>>>>>>>>>>>>#####################################");
        System.err.println("*******************>>>>>>>>>>>>>>>>>>>>>>>>#####################################");
        System.err.println("*******************>>>>>>>>>>>>>>>>>>>>>>>>#####################################");
        System.err.println("*******************>>>>>>>>>>>>>>>>>>>>>>>>#####################################");
        System.err.println("*******************>>>>>>>>>>>>>>>>>>>>>>>>#####################################");
        System.err.println("*******************>>>>>>>>>>>>>>>>>>>>>>>>#####################################");
        System.err.println("*******************>>>>>>>>>>>>>>>>>>>>>>>>#####################################");

        return null;
    }

}
