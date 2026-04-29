package com.nosuchelements.config;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import jakarta.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * • RestAssured Configuration • Central configuration for API testing
 */
@Component
public class RestAssuredConfig {
	@Autowired
	private PropertyConfig propertyConfig;

	/**
	 * o Initialize RestAssured with base configuration
	 */
	@PostConstruct
	public void setup() {
		RestAssured.baseURI = propertyConfig.getApiBaseUrl();
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
	}

	/**
	 * o Get default request specification
	 */
	public RequestSpecification getDefaultRequestSpec() {
		return new RequestSpecBuilder().setContentType(ContentType.JSON).setAccept(ContentType.JSON).log(LogDetail.ALL)
				.build();
	}

	/**
	 * o Get default response specification
	 */
	public ResponseSpecification getDefaultResponseSpec() {
		return new ResponseSpecBuilder().log(LogDetail.ALL).build();
	}

	/**
	 * o Get request specification with Bearer token authentication
	 */
	public RequestSpecification getRequestSpecWithAuth(String token) {
		return new RequestSpecBuilder().setContentType(ContentType.JSON).setAccept(ContentType.JSON)
				.addHeader("Authorization", "Bearer " + token).log(LogDetail.ALL).build();
	}

	/**
	 * o Get request specification with Basic authentication
	 */
	public RequestSpecification getRequestSpecWithBasicAuth(String username, String password) {
		return new RequestSpecBuilder().setContentType(ContentType.JSON).setAccept(ContentType.JSON)
				.setAuth(RestAssured.basic(username, password)).log(LogDetail.ALL).build();
	}
}
