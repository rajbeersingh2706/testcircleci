package com.salido.labor.util;

import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Component
public class ServiceClientGet {

	private static final Logger LOGGER = LogManager.getLogger(ServiceClientGet.class.getName());

	public String callWebService(MultiValueMap<String, String> headers, String jsonRequests, String serviceUrl) {
		LOGGER.debug("Service Url " + serviceUrl);
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		HttpEntity<String> request = new HttpEntity<String>(jsonRequests, headers);
		String response = restTemplate.postForObject(serviceUrl, request, String.class);
		LOGGER.debug("Service Response " + response);
		return response;
	}

	public String callService(MultiValueMap<String, String> headers, String jsonRequests, String serviceUrl) {
		LOGGER.debug("Get Service Url " + serviceUrl);
		RestTemplate restTemplate = new RestTemplate();
		String response = "";
		try {
			HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
			ResponseEntity<String> responseEntity = restTemplate.exchange(serviceUrl, HttpMethod.GET, entity,
					String.class, jsonRequests);
			if (StringUtils.isNotBlank(responseEntity.getBody())) {
				response = responseEntity.getBody();
				LOGGER.debug("Get service Result - status (" + responseEntity.getStatusCode() + ") has body: "
						+ responseEntity.getBody());
			}
		} catch (Exception ex) {
			LOGGER.error("** Exception while validating token: ", ex);
			response = ex.getMessage();
		}
		return response;
	}

}
