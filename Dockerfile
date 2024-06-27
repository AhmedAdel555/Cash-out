FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/Cashout-0.0.1-SNAPSHOT.jar /app/Cashout-0.0.1-SNAPSHOT.jar
EXPOSE 8080
CMD ["java", "-jar", "Cashout-0.0.1-SNAPSHOT.jar"]