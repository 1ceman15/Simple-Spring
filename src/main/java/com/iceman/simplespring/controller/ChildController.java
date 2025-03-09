package com.iceman.simplespring.controller;

import com.iceman.simplespring.entity.Child;
import com.iceman.simplespring.entity.ChildId;
import com.iceman.simplespring.entity.Employer;
import com.iceman.simplespring.repository.ChildRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/children")
public class ChildController {

    private final ChildRepository childRepository;

    public ChildController(ChildRepository childRepository) {
        this.childRepository = childRepository;
    }

    @GetMapping({"/", ""})
    public List<Child> getAllChildren() {
        return childRepository.findAll();
    }


    @GetMapping("/{name}/{tabno}")
    public ResponseEntity<Child> getChildById(@PathVariable String name, @PathVariable String tabno) {
        ChildId childId = new ChildId(name, tabno);
        Optional<Child> child = childRepository.findById(childId);
        return child.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }


    @PostMapping
    public ResponseEntity<Child> createEmployer(@RequestBody Child child) {
        Child savedChild = childRepository.save(child);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedChild.getTabno()).toUri();
        return ResponseEntity.created(location).body(savedChild);
    }

}
