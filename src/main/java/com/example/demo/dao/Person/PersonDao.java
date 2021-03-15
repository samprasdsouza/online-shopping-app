package com.example.demo.dao.Person;

import com.example.demo.model.Person.Person;

import java.util.Optional;
import java.util.UUID;
import java.util.List;

public interface PersonDao {
    String insertPerson(UUID id, Person person);

    default String insertPerson (Person person){
        UUID id = UUID.randomUUID();
        return insertPerson(id,person);
    }

    List<Person> selectAllPeople();

    Person selectPersonById(UUID id);

    int deletePersonById(UUID id);

    int updatePersonById(UUID id,Person person);
}
