FROM openjdk:17

COPY target/ /app/ROOT.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/ROOT.jar"]
