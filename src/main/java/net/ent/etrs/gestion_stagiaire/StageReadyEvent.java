package net.ent.etrs.gestion_stagiaire;

import javafx.stage.Stage;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.Bean;

//@Component
public class StageReadyEvent extends ApplicationEvent{


        public StageReadyEvent(Stage stage) {

            super(stage);
        }

        @Bean
        public Stage getStage() {

            return ((Stage) getSource());
        }
}
