package model.enums;

// Clase utilizada para definir los tipos de Usuarios permitidos en la app
public enum UserType {

    // categorias, y su presentacion en string
    ADMIN("admin"),
    EMPLOYEE("employee"),
    CLIENT("client");

    // Se declara como un valor inmutable luego de declarado
    private final String value;

    // Constructor que recive el valor y lo asigna al valor
    UserType(String value) {
        this.value = value;
    }

    //Getter
    public String getValue() {
        return value;
    }

    // Convierte el string que viene de la base de datos al enum correspondiente
    public static UserType fromValue(String value) {
        for (UserType type : values()) {
            if (type.value.equalsIgnoreCase(value)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Valor de user_type no reconocido: " + value);
    }

    @Override
    public String toString() {
        return value;
    }
}
