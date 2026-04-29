package com.nosuchelements.api;

import io.restassured.response.Response;
import org.springframework.stereotype.Component;

/**
 * • Generic REST Client for API testing • Lambda expression ready for
 * functional API calls • Stores last response for assertions
 */
@Component
public class RestClient extends BaseApiClient {
	private Response lastResponse;

	/**
	 * o Store last response for later assertions
	 */
	public void setLastResponse(Response response) {
		this.lastResponse = response;
	}

	/**
	 * o Get last stored response
	 */
	public Response getLastResponse() {
		return lastResponse;
	}

	/**
	 * o Execute GET and store response
	 */
	public Response executeGet(String endpoint) {
		Response response = get(endpoint);
		setLastResponse(response);
		return response;
	}

	/**
	 * o Execute POST and store response
	 */
	public Response executePost(String endpoint, Object body) {
		Response response = post(endpoint, body);
		setLastResponse(response);
		return response;
	}

	/**
	 * o Execute PUT and store response
	 */
	public Response executePut(String endpoint, Object body) {
		Response response = put(endpoint, body);
		setLastResponse(response);
		return response;
	}

	/**
	 * o Execute DELETE and store response
	 */
	public Response executeDelete(String endpoint) {
		Response response = delete(endpoint);
		setLastResponse(response);
		return response;
	}

	/**
	 * o Execute PATCH and store response
	 */
	public Response executePatch(String endpoint, Object body) {
		Response response = patch(endpoint, body);
		setLastResponse(response);
		return response;
	}
}
