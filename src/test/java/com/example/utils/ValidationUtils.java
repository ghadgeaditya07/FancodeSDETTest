package com.example.utils;

import java.util.List;
import java.util.Map;

public class ValidationUtils {

    // Check if a user has completed more than 50% of their tasks
    public static boolean isMoreThan50PercentCompleted(List<Map<String, Object>> todos) {
        long completedCount = todos.stream()
            .filter(todo -> (Boolean) todo.get("completed"))
            .count();
        return (double) completedCount / todos.size() > 0.5;
    }
}
