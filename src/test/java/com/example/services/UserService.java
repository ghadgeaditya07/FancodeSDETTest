package com.example.services;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserService {

    private static final String BASE_URL = "http://jsonplaceholder.typicode.com";

    // Fetch all users
    public List<Map<String, Object>> getUsers() {
        Response response = RestAssured.get(BASE_URL + "/users");
        if (response.getStatusCode() != 200) {
            throw new RuntimeException("Failed to fetch users: " + response.getStatusCode());
        }
        return response.jsonPath().getList("");
    }

    // Filter users based on FanCode city criteria (latitude and longitude)
    public List<Map<String, Object>> getFanCodeUsers(List<Map<String, Object>> users) {
        return users.stream()
            .filter(user -> {
                Map<String, String> geo = (Map<String, String>) ((Map<String, Object>) user.get("address")).get("geo");
                float lat = Float.parseFloat(geo.get("lat"));
                float lng = Float.parseFloat(geo.get("lng"));
                return lat > -40 && lat < 5 && lng > 5 && lng < 100;
            })
            .collect(Collectors.toList());
    }
}
