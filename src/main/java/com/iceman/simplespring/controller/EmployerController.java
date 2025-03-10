package com.iceman.simplespring.controller;

import com.iceman.simplespring.entity.Employer;
import com.iceman.simplespring.repository.EmployerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RequestMapping("/employers")
@RestController
public class EmployerController {

    private final EmployerRepository employerRepository;

    public EmployerController(EmployerRepository employerRepository) {
        this.employerRepository = employerRepository;
    }

    @GetMapping({"/", ""})
    public List<Employer> getAllEmployers() {
        return employerRepository.findAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Employer> getEmployer(@PathVariable String id) {
        Optional<Employer> employer = employerRepository.findById(id);
        return employer.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Employer> createEmployer(@RequestBody Employer employer) {
        Employer savedEmployer = employerRepository.save(employer);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedEmployer.getTabno()).toUri();
        return ResponseEntity.created(location).body(savedEmployer);
    }

    @DeleteMapping( "/{id}")
    public void deleteEmployer(@PathVariable String id) {
        employerRepository.deleteById(id);
    }
}
