package com.spgi.sitetour.controller;

import com.spgi.sitetour.repo.SiteTourStepRepo;
import com.spgi.sitetour.repo.UseCase;
import com.spgi.sitetour.repo.UseCaseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(method = RequestMethod.POST, path = "/usecase/add")
    public ResponseEntity<UseCase> addUseCase(@RequestBody UseCase useCase) {
        return ResponseEntity.ok(useCaseRepo.save(useCase));
    }
}
