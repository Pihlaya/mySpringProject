package com.example.mySpringProject.controller;

import com.example.mySpringProject.data.example;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/example")
public class ExampleController {

    private List<example> exampleList = new ArrayList<>();

    @GetMapping("/{id}")
    public ResponseEntity<example> getExampleById(@PathVariable int id) {
        if (id >= 0 && id < exampleList.size()) {
            example e = exampleList.get(id);
            return new ResponseEntity<>(e, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Void> addExample(@RequestBody example e) {
        exampleList.add(e);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<example>> getAllExamples() {
        return new ResponseEntity<>(exampleList, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateExample(@PathVariable int id, @RequestBody example e) {
        if (id >= 0 && id < exampleList.size()) {
            exampleList.set(id, e);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExample(@PathVariable int id) {
        if (id >= 0 && id < exampleList.size()) {
            exampleList.remove(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}