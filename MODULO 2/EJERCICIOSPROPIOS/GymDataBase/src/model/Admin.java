package model;

import java.sql.Date;


public class Admin {

    // Atributos particulares que tendra la clase administrador
    private int id;
    private int userId;
    // Los administradores deben tener un cierto nivel de acceso
    private AccessLevel accessLevel;
    private Date entryDate;

    public Admin() {
    }

    // Constructor
    public Admin(int userId, AccessLevel accessLevel, Date entryDate) {
        this.userId = userId;
        this.accessLevel = accessLevel;
        this.entryDate = entryDate;
    }

    public Admin(int id, int userId, AccessLevel accessLevel, Date entryDate) {
        this.id = id;
        this.userId = userId;
        this.accessLevel = accessLevel;
        this.entryDate = entryDate;
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

    public AccessLevel getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(AccessLevel accessLevel) {
        this.accessLevel = accessLevel;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", userId=" + userId +
                ", accessLevel=" + accessLevel +
                ", entryDate=" + entryDate +
                '}';
    }
}