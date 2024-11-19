package org.example.controller;

import org.example.DAO.InscriptionDAO;
import org.example.DAO.ProjectDAO;
import org.example.entities.Inscription;
import org.example.entities.Project;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class InscriptionController {

    private InscriptionDAO inscriptionDAO;

    public InscriptionController(){
        this.inscriptionDAO = new InscriptionDAO();
    }

    public void addProject(int userId, int projectId, Timestamp date){
        Inscription newInscription = new Inscription();
        newInscription.setUserId(userId);
        newInscription.setProjectId(projectId);
        newInscription.setDate(date);

        this.inscriptionDAO.addInscription(newInscription);
    }

    public List<Inscription> getAllInscription(){
        return this.inscriptionDAO.getAllInscription();
    }
}
