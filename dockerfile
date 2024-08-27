FROM openjdk:17-alpine

WORKDIR /opt

COPY target/crudprojects-0.0.1-SNAPSHOT.jar /app/crudprojects-0.0.1-SNAPSHOT.jar

EXPOSE 8086

ENTRYPOINT exec java $JAVA_OPTS -jar crudprojects-0.0.1-SNAPSHOT.jar

