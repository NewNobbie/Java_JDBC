package org.example.controller;

import org.example.DAO.UserDAO;
import org.example.entities.User;
import org.example.enums.Role;

import java.util.List;

public class UserController {

    private UserDAO userDAO;

    public UserController(){
        this.userDAO = new UserDAO();
    }

    public void addUser(String name, String email, String password, Role role){
        User newUser = new User();
        newUser.setName(name);
        newUser.setEmail(email);
        newUser.setPassword(password);
        newUser.setRole(role);

        this.userDAO.addUser(newUser);
    }

    public List<User> getUsers(){
        return this.userDAO.getAllUser();
    }
}
