/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author graci
 */
public class Tasks {

    private int id;
    private int idProject;
    private String name;
    private String description;
    private boolean isCompleted;
    private String notes;
    private Date deadline;
    private Date creationDate;
    private Date updateDate;

    public Tasks(int id, int idProject, String name, String description, boolean isCompleted, String notes, Date deadline, Date creationDate, Date updateDate) {
        this.id = id;
        this.idProject = idProject;
        this.name = name;
        this.description = description;
        this.isCompleted = isCompleted;
        this.notes = notes;
        this.deadline = deadline;
        this.creationDate = creationDate;
        this.updateDate = updateDate;
    }

    public Tasks() {
        this.creationDate = new Date();
        this.updateDate = new Date();
        this.deadline = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdProject() {
        return idProject;
    }

    public void setIdProject(int idProject) {
        this.idProject = idProject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public String toString() {
        return "Tasks{" + "id=" + id + ", idProject=" + idProject + ", name=" + name + ", description=" + description + ", isCompleted=" + isCompleted + ", notes=" + notes + ", deadline=" + deadline + ", creationDate=" + creationDate + ", updateDate=" + updateDate + '}';
    }

}
