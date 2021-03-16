package com.example.demo.helper;

import com.example.demo.model.Person.Person;
import org.springframework.stereotype.Component;

@Component
public class ApiValidation {

        public  boolean personValidator(Person person)
        {
            if(!person.getName().isEmpty())
                return true;
            return false;
        }
        public String NewUserNameFull()
        {
            return"{'Type ':' User Name Already Exist'}";
        }
        public String NewUserSuccess()
         {
             return "{'Type':'User Created Successfully'}";
         }
}
