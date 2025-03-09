package com.iceman.simplespring.controller;

import com.iceman.simplespring.entity.Child;
import com.iceman.simplespring.entity.Department;
import com.iceman.simplespring.repository.DepartmentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentRepository departmentRepository;

    public DepartmentController(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @GetMapping({"/", ""})
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }


    @PostMapping
    public ResponseEntity<Department> createEmployer(@RequestBody Department department) {
        Department savedDepartment = departmentRepository.save(department);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedDepartment.getId()).toUri();
        return ResponseEntity.created(location).body(savedDepartment);
    }

}
