package com.training_app.controller;

import com.training_app.entities.Program;
import com.training_app.service.ProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/programs")
public class ProgramController {

    private final ProgramService programService;

    @Autowired
    public ProgramController(ProgramService programService) {
        this.programService = programService;
    }

    @GetMapping
    public List<Program> getAll() {
        return programService.getAllPrograms();
    }

    @PostMapping
    public void add(@RequestBody Program program) {
        programService.saveProgram(program);
    }

    @GetMapping("/{id}")
    public Program get(@PathVariable("id") Long id) {
        return programService.getProgramById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        programService.deleteProgram(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") Long id, @RequestBody Program program) {
        programService.updateProgram(id, program);
    }
}
