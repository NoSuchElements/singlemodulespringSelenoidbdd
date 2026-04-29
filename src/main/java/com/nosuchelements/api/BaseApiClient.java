package com.nosuchelements.api;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.nosuchelements.config.RestAssuredConfig;

import static io.restassured.RestAssured.given;

/**
 * • Base API Client for all REST API interactions • Provides common HTTP
 * methods
 */
public abstract class BaseApiClient {
	protected static final Logger logger = LoggerFactory.getLogger(BaseApiClient.class);
	@Autowired
	protected RestAssuredConfig restAssuredConfig;

	/**
	 * o Execute GET request
	 */
	protected Response get(String endpoint) {
		logger.info("GET request to: {}", endpoint);
		RequestSpecification request = given().spec(restAssuredConfig.getDefaultRequestSpec());
		Response response = request.when().get(endpoint);
		logResponse(response);
		return response;
	}

	/**
	 * o Execute POST request
	 */
	protected Response post(String endpoint, Object body) {
		logger.info("POST request to: {}", endpoint);
		RequestSpecification request = given().spec(restAssuredConfig.getDefaultRequestSpec()).body(body);
		Response response = request.when().post(endpoint);
		logResponse(response);
		return response;
	}

	/**
	 * o Execute PUT request
	 */
	protected Response put(String endpoint, Object body) {
		logger.info("PUT request to: {}", endpoint);
		RequestSpecification request = given().spec(restAssuredConfig.getDefaultRequestSpec()).body(body);
		Response response = request.when().put(endpoint);
		logResponse(response);
		return response;
	}

	/**
	 * o Execute DELETE request
	 */
	protected Response delete(String endpoint) {
		logger.info("DELETE request to: {}", endpoint);
		RequestSpecification request = given().spec(restAssuredConfig.getDefaultRequestSpec());
		Response response = request.when().delete(endpoint);
		logResponse(response);
		return response;
	}

	/**
	 * o Execute PATCH request
	 */
	protected Response patch(String endpoint, Object body) {
		logger.info("PATCH request to: {}", endpoint);
		RequestSpecification request = given().spec(restAssuredConfig.getDefaultRequestSpec()).body(body);
		Response response = request.when().patch(endpoint);
		logResponse(response);
		return response;
	}

	/**
	 * o Log response details
	 */
	private void logResponse(Response response) {
		logger.info("Response Status: {}", response.getStatusCode());
		logger.debug("Response Time: {}ms", response.getTime());
		logger.debug("Response Body: {}", response.getBody().asString());
	}
}
