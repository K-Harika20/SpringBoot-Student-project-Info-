package com.example.StudentprojectInfo.repository;

import com.example.StudentprojectInfo.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Projectrepository extends JpaRepository<Project,Integer> {
    Project findByRollno(String rollNo);
}
