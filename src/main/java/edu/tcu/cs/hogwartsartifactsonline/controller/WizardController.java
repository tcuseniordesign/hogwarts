package edu.tcu.cs.hogwartsartifactsonline.controller;

import edu.tcu.cs.hogwartsartifactsonline.domain.Result;
import edu.tcu.cs.hogwartsartifactsonline.domain.StatusCode;
import edu.tcu.cs.hogwartsartifactsonline.domain.Wizard;
import edu.tcu.cs.hogwartsartifactsonline.service.WizardService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/wizards")
public class WizardController {
    private WizardService service;

    public WizardController(WizardService service) {
        this.service = service;
    }

    @GetMapping
    public Result findAll() {
        return new Result(true, StatusCode.SUCCESS, "Find All Success", service.findAll());
    }

    @GetMapping("/{wizardId}")
    public Result findById(@PathVariable Integer wizardId) {
        return new Result(true, StatusCode.SUCCESS, "Find One Success",
                service.findById(wizardId));
    }

    @PostMapping
    public Result save(@RequestBody Wizard wizard) {
        service.save(wizard);
        return new Result(true, StatusCode.SUCCESS, "Save Success");
    }

    @PutMapping("/{wizardId}")
    public Result update(@PathVariable Integer wizardId, @RequestBody Wizard wizard) {
        service.update(wizardId, wizard);
        return new Result(true, StatusCode.SUCCESS, "Update Success");
    }

    @DeleteMapping("/{wizardId}")
    public Result deleteById(@PathVariable Integer wizardId) {
        service.deleteById(wizardId);
        return new Result(true, StatusCode.SUCCESS, "Delete Success");
    }

}
