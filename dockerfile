FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY target/crudprojects-0.0.1-SNAPSHOT.jar /app/crudprojects-0.0.1-SNAPSHOT.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/crudprojects-0.0.1-SNAPSHOT.jar"]
