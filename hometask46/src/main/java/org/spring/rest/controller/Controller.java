package org.spring.rest.controller;

import org.spring.rest.entity.Course;
import org.spring.rest.repository.CourseRepository;
import org.spring.rest.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/course")
public class Controller {
    @Autowired
    private CourseService service;

    @GetMapping("/")
    public EntityModel<List<Course>> all() {
        return EntityModel.of(service.all(),
                linkTo(methodOn(Controller.class).create(null)).withRel("to all"));
    }

    @GetMapping("/{id}")
    public EntityModel<Course> byId(@PathVariable(name = "id") UUID id) {
        return EntityModel.of(service.byId(id),
                linkTo(methodOn(Controller.class).all()).withRel("to all"));
    }

    @PostMapping("/")
    public EntityModel<Course> create(@RequestBody Course value) {
        return EntityModel.of(service.create(value),
                linkTo(methodOn(Controller.class).all()).withRel("to all"));
    }

    @PutMapping("/{id}")
    public EntityModel<Course> update(@RequestBody Course value,
                                      @PathVariable(name = "id") UUID id
    ) {
        return EntityModel.of(service.update(value, id),
                linkTo(methodOn(Controller.class).all()).withRel("to all"));
    }

    @DeleteMapping("/{id}")
    public EntityModel<Course> delete(@PathVariable(name = "id") UUID id) {
        return EntityModel.of(service.delete(id),
                linkTo(methodOn(Controller.class).all()).withRel("to all"));
    }
}
