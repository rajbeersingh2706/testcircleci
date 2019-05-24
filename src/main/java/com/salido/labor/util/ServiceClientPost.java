package com.salido.labor.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Component
public class ServiceClientPost {

	private static final Logger LOGGER = LogManager.getLogger(ServiceClientPost.class.getName());

	public String callWebService(String jsonRequests, String serviceUrl, MultiValueMap<String, String> headers) {
		LOGGER.debug("service Url " + serviceUrl);

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		HttpEntity<String> request = new HttpEntity<String>(jsonRequests, headers);
		String response = restTemplate.postForObject(serviceUrl, request, String.class);
		LOGGER.debug("Service Response " + response);
		return response;
	}

	public MultiValueMap<String, String> createHeader(String token) {
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.add("Authorization", token);
		return headers;
	}
}
