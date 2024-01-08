# Usa la imagen oficial de OpenJDK con Java 17 como base
FROM openjdk:17

# Define el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el archivo JAR construido por Gradle a la imagen
COPY build/libs/Pokedex-0.0.1-SNAPSHOT.jar app.jar

# Expone el puerto en el que se ejecuta tu aplicación
EXPOSE 8091

# Comando para ejecutar la aplicación al iniciar el contenedor
CMD ["java", "-jar", "app.jar"]
