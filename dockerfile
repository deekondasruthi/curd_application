FROM openjdk:17

COPY target/crudprojects-0.0.1-SNAPSHOT.jar crudprojects-0.0.1-SNAPSHOT.jar

RUN mv crudprojects-0.0.1-SNAPSHOT.jar ROOT.jar

EXPOSE 8086

ENTRYPOINT ["java", "-jar", "ROOT.jar"]
