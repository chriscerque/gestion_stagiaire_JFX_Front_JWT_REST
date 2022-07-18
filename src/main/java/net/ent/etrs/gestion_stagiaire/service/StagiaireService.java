package net.ent.etrs.gestion_stagiaire.service;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class StagiaireService {

//    @Autowired
//    private StagiaireRepo stagiaireRepo;
//
//    @GetMapping(produces = "application/json;charset=utf-8", path = "/Stagiaires")
//    public List<Stagiaire> getStagiaire(){
//
//        stagiaireRepo.findAll().forEach(s-> System.out.println(String.format("%s : %s | %s", s.getNom(),s.getPrenom(), s.getAppartenance())));
//
//        return stagiaireRepo.findAll();
//    }


}
