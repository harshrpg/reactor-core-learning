package com.hars.learning;

import com.hars.learning.model.Container;
import com.hars.learning.repository.ContainerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Flux;


@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        SpringApplication.run(
                MainApplication.class, args
        );
    }

//    @Bean
//    CommandLineRunner initContainer(ContainerRepository repository){
//		return args -> {
//			Flux<Container> containerFlux =Flux.just(
//					new Container("container1"),
//					new Container("container1"),
//					new Container("container2")
//			).flatMap(repository::save);
//			containerFlux.thenMany(repository.findAll()).subscribe(System.out::println);
//		};
//	}
}
