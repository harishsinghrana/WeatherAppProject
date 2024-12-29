package in.hr.weather.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.hr.weather.app.data.WeatherData;
import in.hr.weather.app.service.WeatherService;
import jakarta.validation.constraints.NotBlank;

@RestController
@RequestMapping(name = "WeatherController", value = "/weather")
public class WeatherController {
	@Autowired
	private WeatherService weatherService;

	@GetMapping("/{postalCode}")
	public ResponseEntity<?> getWeather(@PathVariable @NotBlank  String postalCode) {
		WeatherData data = weatherService.getWeatherData(postalCode);
		return ResponseEntity.ok(data);
	}
}
