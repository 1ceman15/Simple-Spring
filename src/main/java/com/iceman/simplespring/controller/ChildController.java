package com.iceman.simplespring.controller;

import com.iceman.simplespring.entity.Child;
import com.iceman.simplespring.entity.ChildId;
import com.iceman.simplespring.repository.ChildRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
