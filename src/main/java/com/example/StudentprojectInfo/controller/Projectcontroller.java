package com.example.StudentprojectInfo.controller;

import com.example.StudentprojectInfo.dto.Projectrequest;
import com.example.StudentprojectInfo.exception.UserNotFoundException;
import com.example.StudentprojectInfo.model.Project;
import com.example.StudentprojectInfo.service.Projectservice;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
public class Projectcontroller {
    @Autowired
    private Projectservice projectservice;
    @PostMapping("/addproject")
    public ResponseEntity<Project> saveproject(@RequestBody @Valid Projectrequest projectrequest){

        return new ResponseEntity<>(projectservice.saveproject(projectrequest), HttpStatus.OK);
    }
    @PostMapping("/addprojects")
    public List<Project> saveprojects(@RequestBody List<Project> projectrequest){
        return projectservice.saveprojects(projectrequest);
    }
   /* @GetMapping("/{id}")
    public Project getProjectById(@PathVariable("id") int id){
        return projectservice.getProjectById(id);
    }*/
    @GetMapping("/getproject")
    public List<Project> getproject(){
        return projectservice.getproject();
    }
    @PutMapping("/update/{id}")
    public Project updateproject(@PathVariable("id") int id,@RequestBody Project projectrequest){
        return projectservice.updateproject(id,projectrequest);

    }
    @DeleteMapping("/delete/{id}")
    public String deleteproject(@PathVariable("id") int id){
        return projectservice.deleteproject(id);
    }

    @GetMapping("/{rollno}")
    public ResponseEntity<Project> getProjectByRollNo(@PathVariable String rollno) throws UserNotFoundException {
        return ResponseEntity.ok(projectservice.getProjectByRollno(rollno));
    }
}
