package com.nosuchelements.api.endpoints;

import io.restassured.response.Response;
import org.springframework.stereotype.Component;

import com.nosuchelements.api.BaseApiClient;

import java.util.HashMap;
import java.util.Map;

/**
 * • User API Client • Example using ReqRes API (https://reqres.in)
 */
@Component
public class UserApiClient extends BaseApiClient {
	private static final String USERS_ENDPOINT = "/api/users";
	private static final String LOGIN_ENDPOINT = "/api/login";
	private static final String REGISTER_ENDPOINT = "/api/register";

	/**
	 * o Get list of users with pagination
	 */
	public Response getUsers(int page) {
		logger.info("Getting users - page: {}", page);
		return get(USERS_ENDPOINT + "?page=" + page);
	}

	/**
	 * o Get single user by ID
	 */
	public Response getUser(int userId) {
		logger.info("Getting user with ID: {}", userId);
		return get(USERS_ENDPOINT + "/" + userId);
	}

	/**
	 * o Create new user
	 */
	public Response createUser(String name, String job) {
		logger.info("Creating user - name: {}, job: {}", name, job);
		Map<String, String> body = new HashMap<>();
		body.put("name", name);
		body.put("job", job);
		return post(USERS_ENDPOINT, body);
	}

	/**
	 * o Update user (PUT - full update)
	 */
	public Response updateUser(int userId, String name, String job) {
		logger.info("Updating user ID: {} - name: {}, job: {}", userId, name, job);
		Map<String, String> body = new HashMap<>();
		body.put("name", name);
		body.put("job", job);
		return put(USERS_ENDPOINT + "/" + userId, body);
	}

	/**
	 * o Partial update user (PATCH)
	 */
	public Response partialUpdateUser(int userId, Map<String, String> updates) {
		logger.info("Partially updating user ID: {}", userId);
		return patch(USERS_ENDPOINT + "/" + userId, updates);
	}

	/**
	 * o Delete user
	 */
	public Response deleteUser(int userId) {
		logger.info("Deleting user with ID: {}", userId);
		return delete(USERS_ENDPOINT + "/" + userId);
	}

	/**
	 * o Login user
	 */
	public Response loginUser(String email, String password) {
		logger.info("Logging in user: {}", email);
		Map<String, String> body = new HashMap<>();
		body.put("email", email);
		body.put("password", password);
		return post(LOGIN_ENDPOINT, body);
	}

	/**
	 * o Register user
	 */
	public Response registerUser(String email, String password) {
		logger.info("Registering user: {}", email);
		Map<String, String> body = new HashMap<>();
		body.put("email", email);
		body.put("password", password);
		return post(REGISTER_ENDPOINT, body);
	}
}
