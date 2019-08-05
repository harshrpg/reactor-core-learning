package com.hars.learning.controller;

import com.hars.learning.model.Container;
import com.hars.learning.repository.ContainerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

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
}
