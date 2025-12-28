FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY build/libs/users-1.0-SNAPSHOT.jar app.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "app.jar"]
