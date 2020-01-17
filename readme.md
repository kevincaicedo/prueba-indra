# Prueba indra java

Esta prueba fue desarrollada con spring boot + jsf + jpa
puedes encontrar dos proyectos **prueba** es la aplicacion web y **pruebas-rest** que es el servicio web(Rest)

# Run

Como correr el proyecto
- primero desde instalar docker y docker-compose para correo la base de datos en postgrets con el siguiente comando `docker-compose -f database-test.yaml up` el archvio database-test.yaml lo puedes encontrar el la raiz del proyecto
- Luego te mueves hasta la carpeta **pruebas-rest** y ejecutas el siguiente comando ` ./mvnw spring-boot:run` el servio estara disponible por el puerto 8080
- Por ultimo correo el proyecto prueba con el mismo comando ` ./mvnw spring-boot:run` y accedes a `[http://localhost:5000/registro.jsf](http://localhost:5000/registro.jsf)` 


![enter image description here](https://github.com/kevincaicedo/prueba-indra/blob/master/image/Screen%20Shot%202020-01-17%20at%2006.55.53.png?raw=true)

![enter image description here](https://github.com/kevincaicedo/prueba-indra/blob/master/image/Screen%20Shot%202020-01-17%20at%2006.56.28.png?raw=true)
