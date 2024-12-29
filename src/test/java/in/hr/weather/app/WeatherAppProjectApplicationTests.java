package in.hr.weather.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import in.hr.weather.app.controller.UserController;
import in.hr.weather.app.controller.WeatherController;
import in.hr.weather.app.data.WeatherData;
import in.hr.weather.app.service.UserService;
import in.hr.weather.app.service.WeatherService;

@ExtendWith(MockitoExtension.class)
class WeatherAppProjectApplicationTests {

	@Mock
	private WeatherService weatherService;

	@Mock
	private UserService userService;

	@InjectMocks
	private WeatherController weatherController;

	@InjectMocks
	private UserController userController;

	@Test
	public void testGetWeather() {
		String postalCode = "12345";
		String userName = "testUser";
		WeatherData mockWeatherData = new WeatherData();
		mockWeatherData.setTemperature("25.0");
		mockWeatherData.setHumidity("60.0");
		mockWeatherData.setCondition("Clear");

		when(weatherService.getWeatherData(postalCode)).thenReturn(mockWeatherData);

		ResponseEntity<?> response = weatherController.getWeather(postalCode);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(mockWeatherData, response.getBody());
	}


	@Test
	public void testActivateUser() {
		String userName = "testUser";

		ResponseEntity<String> response = (ResponseEntity<String>) userController.activeUser(userName);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals("USER_ACTIVATE_SUCCESS", response.getBody());

	}

	@Test
	public void testDeactivateUser() {
		String userName = "testUser";

		ResponseEntity<String> response =(ResponseEntity<String>) userController.deactiveUser(userName);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		//assertEquals("DEACTIVATE_SUCCESS", response.getBody());

	}

}
