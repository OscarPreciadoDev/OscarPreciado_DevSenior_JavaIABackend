package model;


import model.enums.SubStatus;

import java.sql.Date;

public class Subscription {

    private int id;
    private int clientId;
    private int planId;
    private int employeeId;
    private Date startDate;
    private Date finishDate; // Puede ser null mientras la ticketera siga abierta
    private int visitsUsed;
    private SubStatus subStatus;

    public Subscription() {
    }

    // Constructor para crear una suscripción nueva (antes del INSERT)
    public Subscription(int clientId, int planId, int employeeId, Date startDate) {
        this.clientId = clientId;
        this.planId = planId;
        this.employeeId = employeeId;
        this.startDate = startDate;
        this.visitsUsed = 0;
        this.subStatus = SubStatus.ACTIVE;
    }

    // Constructor completo, útil al mapear un ResultSet
    public Subscription(int id, int clientId, int planId, int employeeId, Date startDate,
                        Date finishDate, int visitsUsed, SubStatus subStatus) {
        this.id = id;
        this.clientId = clientId;
        this.planId = planId;
        this.employeeId = employeeId;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.visitsUsed = visitsUsed;
        this.subStatus = subStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getPlanId() {
        return planId;
    }

    public void setPlanId(int planId) {
        this.planId = planId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public int getVisitsUsed() {
        return visitsUsed;
    }

    public void setVisitsUsed(int visitsUsed) {
        this.visitsUsed = visitsUsed;
    }

    public SubStatus getSubStatus() {
        return subStatus;
    }

    public void setSubStatus(SubStatus subStatus) {
        this.subStatus = subStatus;
    }

    @Override
    public String toString() {
        return "Subscription{" +
                "id=" + id +
                ", clientId=" + clientId +
                ", planId=" + planId +
                ", employeeId=" + employeeId +
                ", startDate=" + startDate +
                ", finishDate=" + finishDate +
                ", visitsUsed=" + visitsUsed +
                ", subStatus=" + subStatus +
                '}';
    }
}
