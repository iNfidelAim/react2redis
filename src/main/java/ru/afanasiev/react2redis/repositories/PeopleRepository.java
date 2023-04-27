package ru.afanasiev.react2redis.repositories;



import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import ru.afanasiev.react2redis.models.Person;

import java.util.Optional;


@Repository
public interface PeopleRepository extends R2dbcRepository<Person, Integer> {
    Optional<Person> findByUsername(String username);
    Flux<Person> findById(String username);
    //Flux<Person> findByUsername(String username);


}
