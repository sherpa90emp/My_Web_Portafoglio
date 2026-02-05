FROM openjdk:17-slim

WORKDIR /app

COPY out/artifacts/backend_my_web_portafoglio_jar/backend-my-web-portafoglio.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]