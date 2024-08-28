FROM openjdk:17-alpine

WORKDIR /opt

RUN mkdir app

COPY target/crudprojects-0.0.1-SNAPSHOT.jar /app/crudprojects-0.0.1-SNAPSHOT.jar

RUN mv /app/crudprojects-0.0.1-SNAPSHOT.jar /app/ROOT.jar

EXPOSE 8086

ENTRYPOINT ["java", "-jar", "/app/ROOT.jar"]

