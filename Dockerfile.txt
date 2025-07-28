# Imagen base oficial de Java 17
FROM openjdk:17-jdk-slim

# Crea carpeta de trabajo
WORKDIR /app

# Copia el JAR generado al contenedor
COPY target/backend-oficina-0.0.1-SNAPSHOT.jar app.jar

# Exponer el puerto que usa Spring Boot
EXPOSE 8080

# Comando para ejecutar la app
ENTRYPOINT ["java", "-jar", "app.jar"]