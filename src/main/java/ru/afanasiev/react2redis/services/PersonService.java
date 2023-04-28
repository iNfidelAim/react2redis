package ru.afanasiev.react2redis.services;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.afanasiev.react2redis.models.Person;
import ru.afanasiev.react2redis.repositories.PeopleRepository;

import java.util.Optional;

public class PersonService {

    PeopleRepository peopleRepository;


    public Flux<Person> findAll() {
        return peopleRepository.findAll();
    }

    public Flux<Person> findByTitleContaining(String title) {
        return peopleRepository.findById(title);
    }

    public Mono<Person> findById(int id) {
        return peopleRepository.findById(id);
    }

    public Mono<Person> save(Person tutorial) {
        return peopleRepository.save(tutorial);
    }

    public Mono<Person> update(int id, Person tutorial) {
        return peopleRepository.findById(id).map(Optional::of).defaultIfEmpty(Optional.empty())
                .flatMap(optionalTutorial -> {
                    if (optionalTutorial.isPresent()) {
                        tutorial.setId(id);
                        return peopleRepository.save(tutorial);
                    }

                    return Mono.empty();
                });

}
    public Mono<Void> deleteById(int id) {
        return peopleRepository.deleteById(id);
    }

    public Mono<Void> deleteAll() {
        return peopleRepository.deleteAll();
    }
//1
}
