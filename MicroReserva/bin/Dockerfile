#inicia con la imagen base que contiene Java runtime
FROM openjdk:17-jdk-slim as build

# se agregar el jar del microservicio al contenedor
COPY target/reservation-0.0.1-SNAPSHOT.jar reservation-0.0.1-SNAPSHOT.jar

#se ejecuta el microservicio
ENTRYPOINT ["java","-jar","/reservation-0.0.1-SNAPSHOT.jar"]