# Weather Application

## Description
This is a Java Spring Boot application that fetches and displays current weather data for a given US postal code using the OpenWeatherMap API. It also saves the history of requests to an mysql database.
Users can be activated or deactivated to access the weather API data

## Features
- Fetches real-time weather data from OpenWeatherMap based on US postal code.
- Stores weather request history (timestamp, postal code, weather conditions).
- Allows retrieval of weather history by postal code or user name.
- User activation and deactivation

## API Endpoints
- `/weather/{postalCode}/{userName}`: Get current weather data for the given postal code, with user name parameter.
- `/weather/history/{postalCode}`: Get weather request history for the given postal code.
- `/weather/history/user/{userName}`: Get weather request history for the given user.
- `/weather/user/activate/{userName}`: Activates a user
- `/weather/user/deactivate/{userName}`: Deactivates a user

## Prerequisites
- Java 17
- Maven
- Docker
- Docker Compose
- An OpenWeatherMap API key

## Setup

### 1. Obtain an OpenWeatherMap API key
- Sign up for a free account at [https://openweathermap.org/](https://openweathermap.org/)
- Obtain an API key.

### 2. Configure API Key
- In the `src/main/resources/application.properties` file, replace `YOUR_API_KEY` with your actual OpenWeatherMap API key:
```properties
openweathermap.api.key=YOUR_API_KEY