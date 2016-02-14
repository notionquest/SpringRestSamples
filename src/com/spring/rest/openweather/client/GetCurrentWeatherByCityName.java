package com.spring.rest.openweather.client;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@EnableAutoConfiguration
public class GetCurrentWeatherByCityName {

	private static final Logger log = LoggerFactory.getLogger(GetCurrentWeatherByCityName.class);

	public static void main(String args[]) {
		SpringApplication.run(GetCurrentWeatherByCityName.class);
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("/getWeatherInfoByCity")
	public String getWeatherInfoByCity() {
		RestTemplate restTemplate = new RestTemplate();

		Map<String, String> urlVariables = new HashMap<String, String>();

		urlVariables.put("q", "London");
		urlVariables.put("appid", "39e531593424bc27e7ae408c4a73a433");
		
		String weatherData = restTemplate.getForObject("http://api.openweathermap.org/data/2.5/weather?q=London&appid=39e531593424bc27e7ae408c4a73a433", String.class);
		
		System.out.println("Weather Data :" + weatherData);
		
		Map<String,Object> weatherMap = new HashMap<String,Object>();

		ObjectMapper mapper = new ObjectMapper();

		try {
			weatherMap = mapper.readValue(weatherData, HashMap.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (String weatherKey: weatherMap.keySet()) {
			System.out.println("Key :" +  weatherKey + "; Key Value :" + weatherMap.get(weatherKey));	
		}
		
		return weatherData;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/getWeatherInfoByCityAsMap")
	public Map<String,Object> getWeatherInfoByCityAsMap() {
		RestTemplate restTemplate = new RestTemplate();

		Map<String, String> urlVariables = new HashMap<String, String>();

		urlVariables.put("q", "London");
		urlVariables.put("appid", "39e531593424bc27e7ae408c4a73a433");
		
		Map<String,Object> weatherMap = restTemplate.getForObject("http://api.openweathermap.org/data/2.5/weather?q=London&appid=39e531593424bc27e7ae408c4a73a433", HashMap.class);
		
		System.out.println("Weather Data :" + weatherMap);
		
		
		for (String weatherKey: weatherMap.keySet()) {
			//System.out.println("Key :" +  weatherKey + "Value :" + weatherMap.get(weatherKey));
			System.out.println("Key :" +  weatherKey + "; Key Value :" + weatherMap.get(weatherKey));	
		}
		
		return weatherMap;
	}
}
