package com.iceman.simplespring.controller;

import com.iceman.simplespring.entity.Department;
import com.iceman.simplespring.repository.DepartmentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
