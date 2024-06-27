FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/cashout-0.0.1-SNAPSHOT.jar /app/cashout-0.0.1-SNAPSHOT.jar
EXPOSE 8080
CMD ["java", "-jar", "cashout-0.0.1-SNAPSHOT.jar"]