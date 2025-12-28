FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY build/libs/auth-1.0-SNAPSHOT.jar app.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "app.jar"]
