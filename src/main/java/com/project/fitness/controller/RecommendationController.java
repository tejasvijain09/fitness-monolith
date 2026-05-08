package com.project.fitness.controller;

import com.project.fitness.dto.RecommendationRequest;
import com.project.fitness.dto.RecommendationResponse;
import com.project.fitness.service.RecommendationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recommendation")
@RequiredArgsConstructor
public class RecommendationController {

    private final RecommendationService recommendationService;

    @PostMapping("/generate")
    public ResponseEntity<RecommendationResponse> generateRecommendation(
            @RequestBody RecommendationRequest request
    ){
        RecommendationResponse response = recommendationService.generateRecommendation(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/user/{userId}") // {userId} = dynamic value (URL ch change ho sakdi)
    public ResponseEntity<List<RecommendationResponse>> getUserRecommendation(
            @PathVariable String userId // URL ch jo {userId} hai, ohdi value uthake variable ch pao”
    ){
        List<RecommendationResponse> recommendationList =
                recommendationService.getUserRecommendation(userId);
        return ResponseEntity.ok(recommendationList);
    }

    @GetMapping("/activity/{activityId}")
    public ResponseEntity<List<RecommendationResponse>> getActivityRecommendation(
            @PathVariable String activityId
    ){
        List<RecommendationResponse> recommendationList =
                recommendationService.getActivityRecommendation(activityId);
        return ResponseEntity.ok(recommendationList);
    }
}

// @PathVariable extracts dynamic values from the URL and binds them to method parameters.