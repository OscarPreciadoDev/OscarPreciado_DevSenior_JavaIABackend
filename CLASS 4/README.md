## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).


Una aplicacion de consola (CLI) para amnejar el inventario de una tienda. Empezamos con un solo producto y al final la hacemos crecer para manejar varios: la app evoluciona delante de ti.

El menu que tendra:
1. Registrar producto
2. Ver producto
3. Actualizar cantidad
4. Ver valor total
5. Salir

## Planeacion del proyecto

Una tienda necesita una herramienta sencilla para registrar producto, consultorio, actualizar su cantidad cuando llega o se vende mercancia y saber cuanto vale su inventario en total. Hoy lo anotan en papel y se pierde. Vamos a construirles esa herramienta por consola

## Que hace la app

1. Muestra un menu
2. El usuario elige una opcion
3. La app responde segun la opcion
4. Vuelve al menu hasta que el usuario salga

## Como se organizara

No meter todo en un archivo gigante. Lo repartidos en piezas, cada una con una sola responsabilidad

1. App -> el director. arranca y coordina
2. Menu ->  muestra el menu y lee la opcion
3. Validador -> revisa que lo que escribe el usuario sea valido
4. Operaciones -> hace el trabajo real con el producto