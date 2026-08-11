package model;

import model.enums.PlanType;

import java.math.BigDecimal;

public class Plan {

    private int id;
    private String planName;
    private PlanType planType;
    private BigDecimal price;
    private Integer daysDuration;    // Puede ser null (ej: ticketera por visitas)
    private Integer visitsIncluded;  // Puede ser null (ej: planes por tiempo)

    public Plan() {
    }

    public Plan(String planName, PlanType planType, BigDecimal price,
                Integer daysDuration, Integer visitsIncluded) {
        this.planName = planName;
        this.planType = planType;
        this.price = price;
        this.daysDuration = daysDuration;
        this.visitsIncluded = visitsIncluded;
    }

    public Plan(int id, String planName, PlanType planType, BigDecimal price,
                Integer daysDuration, Integer visitsIncluded) {
        this.id = id;
        this.planName = planName;
        this.planType = planType;
        this.price = price;
        this.daysDuration = daysDuration;
        this.visitsIncluded = visitsIncluded;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public PlanType getPlanType() {
        return planType;
    }

    public void setPlanType(PlanType planType) {
        this.planType = planType;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getDaysDuration() {
        return daysDuration;
    }

    public void setDaysDuration(Integer daysDuration) {
        this.daysDuration = daysDuration;
    }

    public Integer getVisitsIncluded() {
        return visitsIncluded;
    }

    public void setVisitsIncluded(Integer visitsIncluded) {
        this.visitsIncluded = visitsIncluded;
    }

    @Override
    public String toString() {
        return "Plan{" +
                "id=" + id +
                ", planName='" + planName + '\'' +
                ", planType=" + planType +
                ", price=" + price +
                ", daysDuration=" + daysDuration +
                ", visitsIncluded=" + visitsIncluded +
                '}';
        // Nothing:)xd
    }
}