package com.example.StudentprojectInfo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Project {
    @Id
    @GeneratedValue
    public int id;
    public String rollno;
    public String name;
    public String batch;
    public String email;
    public String phone;
    public String department;
    public String semester;
    public String projectname;
    public String description;
    public String status;
    public String supervisor;
    public String hodname;
    public Date date;
    public String topic;
    public String githublink;
    public String projectlink;
}
