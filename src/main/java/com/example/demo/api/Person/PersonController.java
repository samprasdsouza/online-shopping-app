package com.example.demo.api.Person;

import com.example.demo.api.Topic;
import com.example.demo.helper.ApiValidation;
import com.example.demo.helper.FileUploadHelper;
import com.example.demo.model.Person.Person;
import com.example.demo.service.Person.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import javax.validation.Path;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {
    @Autowired
    private final PersonService personService;

    @Autowired
    private  ApiValidation apiValidation;


    public PersonController(PersonService personService) {

        this.personService = personService;
    }
    @PostMapping
    public  String addPerson (@Valid @NotNull @RequestBody  Person person){
        System.out.println("Adding People");
          //security check class
//         apiValidation.personValidator(person);
         //
     return  personService.addPerson(person);
    }

    @GetMapping
    public List<Person>getALlPeople(){
        return personService.getAllPeople();
    }

    @GetMapping(path ="{id}")
    public Person getPersonById(@PathVariable("id") UUID id) {
        return personService.getPersonById(id);
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

    @GetMapping(path = "/stream")
    public ResponseEntity<InputStreamResource> retrieveResource() throws Exception {
        File file = new File("/Users/Sam/Desktop/demo/src/main/resources/templates/sample.mp4");

        InputStream inputStream = new FileInputStream("/Users/Sam/Desktop/demo/src/main/resources/templates/sample.mp4");
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept-Ranges","bytes");
        headers.set("Content-Type","video/mp4");
        headers.set("Content-Range","bytes 50-1025/17839845");
        headers.set("Content-Length",String.valueOf(file.length()));
        return new ResponseEntity<>(new InputStreamResource(inputStream),headers,HttpStatus.OK);
    }

    @RequestMapping("/topics")
    public  List<Topic> getAllTopics(){
        return Arrays.asList(
                new Topic("sf","spring boot","Spring framework")
        );
    }


}
