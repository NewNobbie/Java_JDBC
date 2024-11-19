package org.example.DAO;

import org.example.entities.Inscription;
import org.example.entities.Project;
import org.example.persistence.database.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class InscriptionDAO {

    public void addInscription(Inscription objInscription){
        String sql = "INSERT INTO inscriptions (userId, projectId, date) VALUES(?, ?, ?);";

        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql))
        {
            statement.setInt(1, objInscription.getUserId());
            statement.setInt(2, objInscription.getProjectId());
            statement.setTimestamp(3, new java.sql.Timestamp(objInscription.getDate().getTime()));

            // Execute SQL declaration
            statement.executeUpdate();

            System.out.println("Inscription be added correctly");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<Inscription> getAllInscription(){
        List<Inscription> inscriptionList = new ArrayList<>();

        String sql = "SELECT * FROM inscriptions;";

        try(Connection connection = DatabaseConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
        ){
            while (resultSet.next()){

                Inscription inscription = new Inscription(
                        resultSet.getInt("id"),
                        resultSet.getInt("user_id"),
                        resultSet.getInt("project_id"),
                        resultSet.getTimestamp("date")
                );
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return inscriptionList;
    }
}
