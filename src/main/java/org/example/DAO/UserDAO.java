package org.example.DAO;

import org.example.entities.User;
import org.example.enums.Role;
import org.example.persistence.database.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {


    public void addUser(User objUser){
        String sql = "INSERT INTO users (name, email, password, role) VALUES(?, ?, ?, ?);";

        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql))
        {
            statement.setString(1, objUser.getName());
            statement.setString(2, objUser.getEmail());
            statement.setString(3, objUser.getPassword());
                statement.setString(4, objUser.getRole().name());

            //Execute the SQL declaration
            statement.executeUpdate();

            System.out.println("Coder be added correctly");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<User> getAllUser(){
        List<User> userList =new ArrayList<>();

        String sql = "SELECT * FROM users;";

        try(Connection connection = DatabaseConnection.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);)
        {
            while (resultSet.next()){

                String roleConvert = resultSet.getString("role");
                Role role = null;
                try{
                    role = Role.valueOf(roleConvert.toUpperCase()); //StringToEnum converter
                }catch (IllegalArgumentException | NullPointerException e){
                    e.printStackTrace(); //Handle invalid or null role values
                }

                User user = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        role
                );
                userList.add(user);

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return userList;
    }
}
