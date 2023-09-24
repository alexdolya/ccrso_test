FROM openjdk:19
WORKDIR /app
COPY target/mcrs_test-0.0.1-SNAPSHOT.jar /app/mcrs_test-0.0.1-SNAPSHOT.jar
CMD ["java", "-jar", "/app/mcrs_test-0.0.1-SNAPSHOT.jar"]

