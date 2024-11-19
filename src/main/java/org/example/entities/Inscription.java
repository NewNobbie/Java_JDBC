package org.example.entities;

import java.sql.Timestamp;

public class Inscription {
    private int id;
    private int userId;
    private int projectId;
    private Timestamp date;


    public Inscription() {
    }

    public Inscription(int id, int userId, int projectId, Timestamp date) {
        this.id = id;
        this.userId = userId;
        this.projectId = projectId;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Inscription{" +
                "id=" + id +
                ", userId=" + userId +
                ", projectId=" + projectId +
                ", date=" + date +
                '}';
    }
}
