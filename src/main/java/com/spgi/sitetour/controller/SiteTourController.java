package com.spgi.sitetour.controller;

import com.spgi.sitetour.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SiteTourController {
    @Autowired
    private UseCaseRepo useCaseRepo;

    @Autowired
    private SiteTourStepRepo siteTourStepRepo;
    public UseCase useCase;

    @RequestMapping(method = RequestMethod.GET, path = "/usecase/{id}")
    public ResponseEntity<UseCase> getUseCase(@PathVariable final Integer id) {
        return ResponseEntity.ok(useCaseRepo.findById(id).get());
    }

    @RequestMapping(method = RequestMethod.GET, path = "/usecases")
    public ResponseEntity<List<UseCase>> getAllUseCases() {
        return ResponseEntity.ok(useCaseRepo.findAll());
    }

    @RequestMapping(method = RequestMethod.POST, path = "/usecase/add")
    public ResponseEntity<List<SiteTourStep>> addUseCase(@RequestBody UseCase useCase) {
        UseCase uc = UseCase.builder().useCaseId(useCase.getUseCaseId()).description(useCase.getDescription()).instruction(useCase.getInstruction()).build();
        useCaseRepo.save(uc);
        List<SiteTourStep> steps = setUseCaseId(useCase.getSiteTourSteps(), uc);
        return ResponseEntity.ok(siteTourStepRepo.saveAll(steps));
    }

    @RequestMapping(method = RequestMethod.GET, path = "/datamodel")
    public ResponseEntity<List<DataModel>> getDataModel() {
        List<UseCase> useCases = useCaseRepo.findAll();
        List<DataModel> dataModels = useCases.stream().map(uc -> DataModel.builder().question(uc.getDescription()).answer(uc.getInstruction()).build()).collect(Collectors.toList());
        return ResponseEntity.ok(dataModels);
    }

    private List<SiteTourStep> setUseCaseId(List<SiteTourStep> steps, UseCase useCase) {
        List<SiteTourStep> listSteps = new ArrayList<>();
        for(SiteTourStep step : steps){
            step.setUseCase(useCase);
            listSteps.add(step);
        }
        return listSteps;
    }
}
