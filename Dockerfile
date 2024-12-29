FROM openjdk:17-jdk-slim
WORKDIR /weatherapp
COPY target/*.jar WeatherApp.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "WeatherApp.jar"]