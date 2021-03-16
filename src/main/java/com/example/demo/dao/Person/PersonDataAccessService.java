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
import java.sql.ResultSet;
import java.sql.SQLException;
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
    public Person selectPersonById(UUID id) {
        System.out.println("Executing Query");
    List<Person> persons = jdbcTemplate.query("select * from Person where id =?",
                new Object[]{id}, (resultSet, i) -> {
                    return toPerson(resultSet);
                });
//    System.out.println("returning NULL");
    if (persons.size() == 1) return persons.get(0);
        System.out.println("returning NULL");
        return null;
    }

    @Override
    public int deletePersonById(UUID id) {
        return 0;
    }

    @Override
    public int updatePersonById(UUID id, Person person) {

        System.out.println(id);

        System.out.println(person.getName());
        jdbcTemplate.update("UPDATE person SET name=? Where id=?",person.getName(),id);
        // update Query
        System.out.println("Update Done");
        return 0;
    }

    private Person toPerson(ResultSet resultSet) throws SQLException {
        Person person = new Person();
        System.out.println("new object");
//        person.setid(resultSet.getLong("id"));
        person.setName(resultSet.getString("name"));
        System.out.println(person.getName());
        return person;
    }
}
