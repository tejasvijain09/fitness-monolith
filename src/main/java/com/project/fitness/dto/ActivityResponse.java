package com.project.fitness.dto;

import com.project.fitness.model.ActivityType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActivityResponse { //Yeh class represent karti hai: “Client ko kya data return karna hai”

    private String id;
    private String userId;
    private ActivityType type;
    Map<String, Object> additionalMetrics;
    private Integer duration;
    private Integer caloriesBurned;
    private LocalDateTime startTime;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
// ActivityResponse defines the structured data returned to the client for an activity.
// Controller request leke Service nu dinda, Service logic laake Repository ton data kadhda, te DTO bana ke wapas bhej dinda.
