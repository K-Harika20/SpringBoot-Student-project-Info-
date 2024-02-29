package com.example.StudentprojectInfo.service;

import com.example.StudentprojectInfo.dto.Projectrequest;
import com.example.StudentprojectInfo.exception.UserNotFoundException;
import com.example.StudentprojectInfo.model.Project;
import com.example.StudentprojectInfo.repository.Projectrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class Projectservice {
    @Autowired
    private Projectrepository repo;

    public Project saveproject(Projectrequest projectRequest) {
        Project project = new Project();

        project.setRollno(projectRequest.getRollno());
        project.setName(projectRequest.getName());
        project.setBatch(projectRequest.getBatch());
        project.setEmail(projectRequest.getEmail());
        project.setPhone(projectRequest.getPhone());
        project.setDepartment(projectRequest.getDepartment());
        project.setSemester(projectRequest.getSemester());
        project.setProjectname(projectRequest.getProjectname());
        project.setDescription(projectRequest.getDescription());
        project.setStatus(projectRequest.getStatus());
        project.setSupervisor(projectRequest.getSupervisor());
        project.setHodname(projectRequest.getHodname());
        project.setDate(projectRequest.getDate());
        project.setTopic(projectRequest.getTopic());
        project.setGithublink(projectRequest.getGithublink());
        project.setProjectlink(projectRequest.getProjectlink());
        return repo.save(project);

    }

    public List<Project> getproject() {
        return repo.findAll();
    }

    /*public Project getProjectById(int id) {
        return repo.findById(id).get();
    }*/

    public String deleteproject(int id) {
        repo.deleteById(id);
        return "project removed !! " + id;
    }


    public Project updateproject(int id, Project projectrequest) {

        Project project = repo.findById(id).get();
        project.setRollno(projectrequest.getRollno());
        project.setName(projectrequest.getName());
        project.setBatch(projectrequest.getBatch());
        project.setEmail(projectrequest.getEmail());
        project.setPhone(projectrequest.getPhone());
        project.setDepartment(projectrequest.getDepartment());
        project.setSemester(projectrequest.getSemester());
        project.setProjectname(projectrequest.getProjectname());
        project.setDescription(projectrequest.getDescription());
        project.setStatus(projectrequest.getStatus());
        project.setSupervisor(projectrequest.getSupervisor());
        project.setHodname(projectrequest.getHodname());
        project.setDate(projectrequest.getDate());
        project.setTopic(projectrequest.getTopic());
        project.setGithublink(projectrequest.getGithublink());
        project.setProjectlink(projectrequest.getProjectlink());
        return repo.save(project);


    }

    public List<Project> saveprojects(List<Project> projectrequest) {
        return repo.saveAll(projectrequest);
    }

    public Project getProjectByRollno(String rollno) throws UserNotFoundException {
        Project p = repo.findByRollno(rollno);
        if(p != null){
            return p;
        } else {
            throw new UserNotFoundException("User not found with roll number: " + rollno);
        }
    }
}
