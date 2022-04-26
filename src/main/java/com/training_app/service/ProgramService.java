package com.training_app.service;

import com.training_app.entities.Program;
import com.training_app.entities.ProgramsStatus;
import com.training_app.repository.ProgramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProgramService {

    private final ProgramRepository repository;

    @Autowired
    public ProgramService(ProgramRepository repository) {
        this.repository = repository;
    }

    public void saveProgram(Program program) {
        if (program != null) {
            program.setStatus(ProgramsStatus.NEW);
            repository.save(program);
        }
    }

    public void updateProgram(Long id, Program updateProgram) {
        Program program = getProgramById(id);

        if (updateProgram.getName() != null) program.setName(updateProgram.getName());

        if (updateProgram.getLength() != null) program.setLength(updateProgram.getLength());

        if (updateProgram.getStatus() != null) program.setStatus(updateProgram.getStatus());

        repository.save(program);
    }

    public void deleteProgram(Long id) {
        Program program = getProgramById(id);
        repository.delete(program);
    }

    public Program getProgramById(Long id) {

        return repository
                .findById(id)
                .orElseThrow(
                        () -> new NoSuchElementException("Ticket not found by this id :: " + id)
                );
    }

    public List<Program> getAllPrograms() {

        return repository.findAll();
    }
}
