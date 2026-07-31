-- Base de datos del gimnasio
USE gymdatabase;

-- Creacion de la tabla de usuarios
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY ,
    first_name VARCHAR(255) NOT NULL,
    second_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    user_type ENUM('admin', 'employee','client') NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Creacion de la tabla de clientes
CREATE TABLE clients (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL UNIQUE ,
    birth_date DATE,

    -- relaciona el user_id con el id de la tabla de users
    FOREIGN KEY (user_id)
    REFERENCES users(id)
    -- Si se elimina el registro de la tabla users, se elimina el registro en esta
    ON DELETE CASCADE
);

-- Creacion de la tabla de empleados
CREATE TABLE employees (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL UNIQUE,
    entry_date DATE NOT
    FOREIGN KEY(user_id)
    REFERENCES users(id)
    ON DELETE CASCADE
);

-- Creacion de la tabla de administradores
CREATE TABLE admins (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL UNIQUE,
    access_level enum('basic','super') NOT NULL,
    entry_date DATE NOT N
    FOREIGN KEY(user_id)
    REFERENCES users(id)
    ON DELETE CASCADE
);

CREATE TABLE plans (
    id INT AUTO_INCREMENT PRIMARY KEY,
    plan_name VARCHAR(50) NOT NULL,
    plan_type ENUM('annual', 'monthly', 'daily', 'ticket_7_days') NOT NULL,
    price DECIMAL(10,2)  NOT NULL,
    days_duration INT NULL,
    visits_included INT NULL
);

CREATE TABLE subscriptions (
    id INT AUTO_INCREMENT PRIMARY KEY,
    client_id INT NOT NULL,
    plan_id INT NOT NULL,
    employee_id INT NOT NULL,
    start_date DATE NOT NULL,
    -- Puede quedar null por el uso de la tiquetera de 7 días
    finish_date DATE NULL,
    visits_used INT NOT NULL DEFAULT 0,
    -- Siempre se activará una subscripcion al crearse
    sub_status ENUM('active','inactive') NOT NULL DEFAULT 'active',
    FOREIGN KEY (client_id) REFERENCES clients(id),
    FOREIGN KEY (plan_id) REFERENCES plans(id),
    -- No se eliminará el registro de eliminarse en usuario empleado
    FOREIGN KEY (employee_id) REFERENCES employees(id) ON DELETE RESTRICT
);