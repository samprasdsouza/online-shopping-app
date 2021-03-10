package com.example.demo.helper;

import com.example.demo.model.Person;
import org.springframework.stereotype.Component;

@Component
public class ApiValidation {

        public  boolean personValidator(Person person)
        {
            if(!person.getName().isEmpty())
                return true;
            return false;
        }
}
