package com.iceman.simplespring.controller;

import com.iceman.simplespring.entity.Employer;
import com.iceman.simplespring.repository.EmployerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
