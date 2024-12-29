package in.hr.weather.app.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WeatherApiConfig {

	@Value("${openweathermap.api.key}")
	private String weatherApiKey;
	@Value("${openweathermap.api.url}")
	private String weatherApiUrl;

	public String getWeatherApiKey() {
		return weatherApiKey;
	}

	public void setWeatherApiKey(String weatherApiKey) {
		this.weatherApiKey = weatherApiKey;
	}

	public String getWeatherApiUrl() {
		return weatherApiUrl;
	}

	public void setWeatherApiUrl(String weatherApiUrl) {
		this.weatherApiUrl = weatherApiUrl;
	}

}
