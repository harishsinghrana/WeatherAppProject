package in.hr.weather.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import in.hr.weather.app.config.WeatherApiConfig;
import in.hr.weather.app.data.WeatherData;

@Service
public class WeatherService {

	@Autowired
	public WeatherApiConfig apiConfig;

	public WeatherData getWeatherData(String postalCode) {
		String url = apiConfig.getWeatherApiUrl() + "?zip=" + postalCode + ",us&appid=" + apiConfig.getWeatherApiKey();
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject(url, WeatherData.class);
	}


}
