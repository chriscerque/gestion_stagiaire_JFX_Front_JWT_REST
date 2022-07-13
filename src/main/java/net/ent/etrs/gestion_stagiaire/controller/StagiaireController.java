package net.ent.etrs.gestion_stagiaire.controller;

import net.ent.etrs.gestion_stagiaire.model.entities.Stage;
import net.ent.etrs.gestion_stagiaire.model.entities.Stagiaire;
import net.ent.etrs.gestion_stagiaire.repo.StageRepo;
import net.ent.etrs.gestion_stagiaire.repo.StagiaireRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value ="/")
public class StagiaireController {

    @Autowired
    private StagiaireRepo stagiaireRepo;

    @GetMapping(produces = "application/json;charset=utf-8", path = "/Stagiaires")
    public List<Stagiaire> getStagiaire(){

        stagiaireRepo.findAll().forEach(s-> System.out.println(String.format("%s : %s | %s", s.getNom(),s.getPrenom(), s.getAppartenance())));

        return stagiaireRepo.findAll();
    }



}
