FROM openjdk:11.0.11
ARG JAR_FILE=target/UFPSaberPRO-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} .
CMD [ "java", "-jar",  "/UFPSaberPRO-0.0.1-SNAPSHOT.jar"]