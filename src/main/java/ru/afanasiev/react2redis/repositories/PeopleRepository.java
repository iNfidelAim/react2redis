package ru.afanasiev.react2redis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.afanasiev.react2redis.models.Person;

import java.util.Optional;


@Repository
public interface PeopleRepository extends JpaRepository<Person, Integer>  {
    Optional<Person> findByUsername(String username);



}
