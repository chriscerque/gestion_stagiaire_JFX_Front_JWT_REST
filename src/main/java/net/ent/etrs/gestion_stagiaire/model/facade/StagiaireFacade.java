package net.ent.etrs.gestion_stagiaire.model.facade;

import net.ent.etrs.gestion_stagiaire.model.entities.Stagiaire;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StagiaireFacade extends AbstractFacade implements IStagiaireFacade {
    @Override
    public Stagiaire saveStagiaire(Stagiaire stagiaire) {
        return null;
    }

    @Override
    public void deleteStagiaire(Stagiaire stagiaire) {

    }

    @Override
    public Stagiaire readStagiaire(Long id) {
        return null;
    }

    @Override
    public List<Stagiaire> readAllStagiaire() {
        return null;
    }

    @Override
    public Stagiaire readStage(String nom, String prenom) {
        return null;
    }


//    @Override
//    public Stagiaire saveStagiaire(Stagiaire stagiaire) {
//        Stagiaire st = this.stagiaireRepo.findStagiaireByNomAndPrenom(stagiaire.getNom(), stagiaire.getPrenom());
//        if(st == null){
//            return this.stagiaireRepo.save(stagiaire);
//        }
//        return st;
//    }
//
//    @Override
//    public void deleteStagiaire(Stagiaire stagiaire) {
//        this.stagiaireRepo.delete(stagiaire);
//    }
//
//    @Override
//    public Stagiaire readStagiaire(Long id) {
//        return null;
//    }
//
//    @Override
//    public List<Stagiaire> readAllStagiaire() {
//        return super.stagiaireRepo.findAll();
//    }
//
//    @Override
//    public Stagiaire readStage(String nom, String prenom) {
//        return null;
//    }
}
