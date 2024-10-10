package com.example.tests;

import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.services.TodoService;
import com.example.services.UserService;
import com.example.utils.ValidationUtils;

public class FancodeSDETTest {

    private final UserService userService = new UserService();
    private final TodoService todoService = new TodoService();

    @Test
    public void testFanCodeUserTodoCompletion() {
        // Step 1: Fetch all users
        List<Map<String, Object>> users = userService.getUsers();

        // Step 2: Filter users from FanCode city
        List<Map<String, Object>> fanCodeUsers = userService.getFanCodeUsers(users);

        // Step 3: For each FanCode user, fetch their todos and validate completion percentage
        for (Map<String, Object> user : fanCodeUsers) {
            int userId = (Integer) user.get("id");
            List<Map<String, Object>> todos = todoService.getTodosByUserId(userId);

            boolean isAboveThreshold = ValidationUtils.isMoreThan50PercentCompleted(todos);

            // Step 4: Assert that the user has completed more than 50% of their tasks
            Assert.assertTrue(isAboveThreshold, "User ID " + userId + " has not completed more than 50% of tasks.");
        }
    }
}
