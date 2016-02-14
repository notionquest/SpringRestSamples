package com.spring.rest.flickr.client;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@EnableAutoConfiguration
public class FlickrPeopleGetInfo {
		
	public static void main(String[] args) throws Exception {
        SpringApplication.run(FlickrPeopleGetInfo.class, args);
    }	
	
    @RequestMapping("/getFlickrPeopleInfo")
	public String getFlickrPeopleInfo() {
		final String uri = "https://www.flickr.com/people/";

		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri, String.class);
		
		Map<String, String> urlVariables = new HashMap<String, String>();
		
		urlVariables.put("user_id", "12037949754@N01");
		
		restTemplate.getForObject(uri, String.class, urlVariables);

		System.out.println(result);
		
		return result;
	}
}
