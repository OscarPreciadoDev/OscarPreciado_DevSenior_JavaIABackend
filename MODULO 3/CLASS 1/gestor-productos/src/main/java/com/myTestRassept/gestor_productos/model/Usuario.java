package com.myTestRassept.gestor_productos.model;

import jakarta.persistence.*;


// Usuario será una tabla en la base de datos, asi que se relaciona con @Entity
@Entity
@Table(name= "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Se establece la regla de que los emails deben ser unicos
    @Column(unique = true)
    private String email;

    private String password;

    // Utilizamos los roles enum
    @Enumerated(EnumType.STRING)
    private Rol rol;

    // Constructor vacio solicitado por Spring
    public Usuario() {
    }

    // getters y setters de todos los campos

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}