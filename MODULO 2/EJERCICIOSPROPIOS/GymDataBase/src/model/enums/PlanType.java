package model.enums;

public enum PlanType {
    ANNUAL("annual"),
    MONTHLY("monthly"),
    DAILY("daily"),
    TICKET_7_DAYS("ticket_7_days");

    private final String value;

    PlanType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static PlanType fromValue(String value) {
        for (PlanType type : values()) {
            if (type.value.equalsIgnoreCase(value)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Valor de plan_type no reconocido: " + value);
    }

    @Override
    public String toString() {
        return value;
    }
}
