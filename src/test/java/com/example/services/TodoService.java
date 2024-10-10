package com.example.services;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import java.util.List;
import java.util.Map;

public class TodoService {

    private static final String BASE_URL = "http://jsonplaceholder.typicode.com";

    // Fetch todos for a specific user by their userId
    public List<Map<String, Object>> getTodosByUserId(int userId) {
        Response response = RestAssured.get(BASE_URL + "/todos?userId=" + userId);
        if (response.getStatusCode() != 200) {
            throw new RuntimeException("Failed to fetch todos for user: " + userId);
        }
        return response.jsonPath().getList("");
    }
}
