package org.example.controller;
import org.example.DAO.ProjectDAO;
import org.example.entities.Project;


import java.util.Date;
import java.util.List;

public class ProjectController {

    private ProjectDAO projectDAO;

    public ProjectController(){
        this.projectDAO = new ProjectDAO();
    }

    public void addProject(String title, String description, Date startDate, Date endDate , int createdBy){
        Project newProject = new Project();
        newProject.setTitle(title);
        newProject.setDescription(description);
        newProject.setStartDate(startDate);
        newProject.setEndDate(endDate);
        newProject.setCreatedBy(createdBy);

        this.projectDAO.addProject(newProject);
    }

    public List<Project> getAllProject(){
        return this.projectDAO.getAllProject();
    }
}
