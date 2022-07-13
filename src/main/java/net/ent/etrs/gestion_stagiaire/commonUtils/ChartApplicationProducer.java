package net.ent.etrs.gestion_stagiaire.commonUtils;

import net.ent.etrs.gestion_stagiaire.ChartApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ChartApplicationProducer {

    @Bean(name = "ChartApplication")
    public ChartApplication getChartApplication(){
        ChartApplication chartApplication = new ChartApplication();
//        System.out.println("$$$$$$$ ChartApplicationProducer/getChartApplication");
//        System.out.println("$$$$$$$>>>>> chartApplication : " + chartApplication);
        return chartApplication;
    }
}
