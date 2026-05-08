package com.project.fitness.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecommendationResponse {

    private String id;
    private String userId;
    private String activityId;

    private String improvements;
    private String suggestions;
    private String safety;
}