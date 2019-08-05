package com.hars.learning.repository;

import com.hars.learning.model.Container;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ContainerRepository extends ReactiveMongoRepository<Container, String> {
}
