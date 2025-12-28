FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
# Copy all JARs, then move the non-plain JAR to app.jar
COPY build/libs/*.jar .
RUN for f in *.jar; do if [ "${f#*-plain.jar}" = "$f" ]; then mv "$f" app.jar; fi; done
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "app.jar"]
