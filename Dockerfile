FROM maven:3.8.6-eclipse-temurin-17

WORKDIR /app

COPY . .

RUN mvn package

EXPOSE 8080

CMD ["java", "-jar", "hoen-scanner-1.0-SNAPSHOT.jar", "server", "config.yml"]



