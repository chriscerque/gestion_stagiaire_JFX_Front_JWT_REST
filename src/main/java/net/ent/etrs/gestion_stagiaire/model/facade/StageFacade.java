package net.ent.etrs.gestion_stagiaire.model.facade;

import net.ent.etrs.gestion_stagiaire.model.entities.Stage;

import java.util.List;
import java.util.Optional;

//@Component
public class StageFacade extends AbstractFacade implements IStageFacade {
    @Override
    public Stage saveStage(Stage stage) {
        return null;
    }

    @Override
    public void deleteStage(Stage stage) {

    }

    @Override
    public Optional<Stage> readStage(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Stage> readAllStage() {
        return null;
    }

    @Override
    public Stage readStage(String codeStage) {
        return null;
    }
//    @Override
//    public Stage saveStage(Stage stage) {
//        Stage st = this.stageRepo.findByCodeStage(stage.getCodeStage());
//        if(st == null){
//            return this.stageRepo.save(stage);
//        }
//        return st;
//    }
//
//    @Override
//    public void deleteStage(Stage stage) {
//        this.stageRepo.delete(stage);
//    }
//
//    @Override
//    public Optional<Stage> readStage(Long id) {
//        return this.stageRepo.findById(id);
//    }
//
//    @Override
//    public List<Stage> readAllStage() {
//        return this.stageRepo.findAll();
//    }
//
//    @Override
//    public Stage readStage(String codeStage) {
//        return this.stageRepo.findByCodeStage(codeStage);
//    }
}
