package org.example.DAO;

import org.example.entities.Project;
import org.example.persistence.database.DatabaseConnection;

import java.io.Flushable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProjectDAO {

    public void addProject(Project objProject){
        String sql = "INSERT INTO projects (title, description, startDate, endDate, createdBy) VALUES(?, ?, ?, ?, ?);";

        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql))
        {
            statement.setString(1, objProject.getTitle());
            statement.setString(2, objProject.getDescription());
            statement.setDate(3, new java.sql.Date(objProject.getStartDate().getTime()));
            statement.setDate(4, new java.sql.Date(objProject.getEndDate().getTime()));
            statement.setInt(5, objProject.getCreatedBy());

            //Execute SQL declaration
            statement.executeUpdate();

            System.out.println("Project be added correctly");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<Project> getAllProject(){
        List<Project> projectList = new ArrayList<>();

        String sql = "SELECT * FROM projects;";

        try(Connection connection = DatabaseConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
        ){
            while (resultSet.next()){

                Project project = new Project(
                        resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getString("description"),
                        resultSet.getDate("start_date"),
                        resultSet.getDate("end_date"),
                        resultSet.getInt("created_by")
                );
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return projectList;
    }
}
