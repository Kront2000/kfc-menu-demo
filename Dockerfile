FROM openjdk:17-jdk-slim-buster
WORKDIR /app
COPY target/Antosha-0.0.1-SNAPSHOT.jar /app/Gyrmania.jar
ENTRYPOINT ["java","-jar", "Gyrmania.jar"]