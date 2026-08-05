package model.enums;

public enum SubStatus {
    ACTIVE("active"),
    INACTIVE("inactive");

    private final String value;

    SubStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static SubStatus fromValue(String value) {
        for (SubStatus status : values()) {
            if (status.value.equalsIgnoreCase(value)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Valor de sub_status no reconocido: " + value);
    }

    @Override
    public String toString() {
        return value;
    }
}