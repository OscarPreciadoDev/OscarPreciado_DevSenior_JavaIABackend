-- Base de datos del gimnasio
CREATE DATABASE IF NOT EXISTS gimnasio;
USE gimnasio;

CREATE TABLE IF NOT EXISTS miembro (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    plan VARCHAR(50) NOT NULL
);
