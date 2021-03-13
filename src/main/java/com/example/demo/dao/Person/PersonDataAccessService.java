package com.example.demo.dao.Person;

import com.example.demo.helper.ApiValidation;
import com.example.demo.model.Person.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository("postgres")
public class PersonDataAccessService implements PersonDao {

    private  static List<Person> DB= new ArrayList<>();
    @Autowired
    private ApiValidation apiValidation;
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public PersonDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public String insertPerson(UUID id, Person person) {
        System.out.println("Added new person");
//        System.out.println(id);
//                person.getName());
//
        String name =person.getName();
        int val  = jdbcTemplate.queryForObject("select count(*) from person where name=? ",new Object[] { name },Integer.class);
        System.out.println(val);
        if(val == 1)
            return apiValidation.NewUserNameFull();
        else
            jdbcTemplate.update("INSERT INTO person(id,name) VALUES(?,?)", id, person.getName());
        return apiValidation.NewUserSuccess();
    }

    @Override
    public List<Person> selectAllPeople() {
        System.out.println("Selecting People");
        final String sql  = "Select id,name from person";
        List<Person> people = jdbcTemplate.query(sql,(resultSet,i)->{
           UUID id =  UUID.fromString(resultSet.getString("id"));
           String name =  resultSet.getString("name");
            return new Person(id ,name );
        });
        return people;
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return Optional.empty();
    }

    @Override
    public int deletePersonById(UUID id) {
        return 0;
    }

    @Override
    public int updatePersonById(UUID id, Person person) {
        return 0;
    }
}
