package com.example.demo.api;

import com.example.demo.helper.FileUploadHelper;
import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.UUID;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }
    @PostMapping
    public  void addPerson (@Valid @NotNull @RequestBody  Person person){
         personService.addPerson(person);
    }

    @GetMapping
    public List<Person>getALlPeople(){
        return personService.getAllPeople();
    }
    @GetMapping(path ="{id}")
    public Person getPersonById(@PathVariable("id") UUID id) {
        return personService.getPersonById(id)
                .orElse(null);
    }
    @DeleteMapping(path ="{id}")
    public void deletePersonById(@PathVariable("id") UUID id){
        personService.deletePerson(id);
    }
    @PutMapping(path ="{id}" )
    public void updatePerson(@PathVariable("id")UUID id,@Valid @NotNull @RequestBody Person personToUpdate){
        personService.updatePerson(id, personToUpdate);
    }

    @Autowired
    private FileUploadHelper fileUploadHelper;
    @PostMapping(path = "/upload-file")
    public ResponseEntity<String> uploadFile(@RequestParam("file")MultipartFile file){
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getContentType());


        try {
            // validation
            if (file.isEmpty()) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request Must Contain File");
            }
            if (!file.getContentType().equals("image/jpeg")) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request Must Contain JPEG File");
            }

            // file upload code  // upload_dir
            ///Users/Sam/Desktop/demo/src/main/resources/static

            boolean check = fileUploadHelper.uploadFile(file);
            if(check) {
                return ResponseEntity.ok("File Uploaded");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Not Uploaded");
    }
}
