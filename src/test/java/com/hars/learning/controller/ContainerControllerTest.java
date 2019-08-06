package com.hars.learning.controller;

import com.hars.learning.model.Container;
import com.hars.learning.repository.ContainerRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebFluxTest(ContainerController.class)
class ContainerControllerTest {

    @Autowired
    WebTestClient webTestClient;

    @MockBean
    private ContainerRepository containerRepository;

    private static final String URI = "http://localhost:8080/containers";

    @Test
    public void saveContainerTest() {
        // GIVEN: A container to be saved to the server
        Container container = new Container("container");
        container.setId("id123");
        Mono<Container> containerMono = Mono.just(container);

        // WHEN: repository is requested to save the container
        when(containerRepository.save(container)).thenReturn(containerMono);

        // THEN: repository returns a containerMono and sends isCreated status
        webTestClient.post()
                .uri("/containers/container")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(container),Container.class)
                .exchange()
                .expectStatus().isCreated();
    }

}