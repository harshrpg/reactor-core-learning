package com.hars.learning.controller;

import com.hars.learning.model.Container;
import com.hars.learning.repository.ContainerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/containers")
public class ContainerController {

    private ContainerRepository containerRepository;

    public ContainerController(ContainerRepository containerRepository) {
        this.containerRepository = containerRepository;
    }

    @GetMapping
    public Flux<Container> getAllContainers() {
        return containerRepository.findAll();
    }

    @PostMapping(value = "/container", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Container> createContainer(@RequestBody Container container) {
        return containerRepository.save(container);
    }

    @PostMapping(value = "/containers", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Flux<Container> createContainers(@RequestBody Iterable<Container> containers) {
        return containerRepository.saveAll(containers);
    }
}
