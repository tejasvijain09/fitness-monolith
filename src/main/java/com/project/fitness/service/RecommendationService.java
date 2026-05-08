package com.project.fitness.service;

import com.project.fitness.dto.RecommendationRequest;
import com.project.fitness.dto.RecommendationResponse;
import com.project.fitness.model.Activity;
import com.project.fitness.model.Recommendation;
import com.project.fitness.model.User;
import com.project.fitness.repository.ActivityRepository;
import com.project.fitness.repository.RecommendationRepository;
import com.project.fitness.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecommendationService {

    private final UserRepository userRepository;
    private final ActivityRepository activityRepository;
    private final RecommendationRepository recommendationRepository;

    public RecommendationResponse generateRecommendation(RecommendationRequest request) {

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User Not Found: " + request.getUserId()));

        Activity activity = activityRepository.findById(request.getActivityId())
                .orElseThrow(() -> new RuntimeException("Activity Not Found: " + request.getActivityId()));

        Recommendation recommendation = Recommendation.builder()
                .user(user)
                .activity(activity)
                .improvements(request.getImprovements())
                .suggestions(request.getSuggestions())
                .safety(request.getSafety())
                .build();

        Recommendation saved = recommendationRepository.save(recommendation);

        return mapToResponse(saved);
    }

    // 🔄 ENTITY → DTO Mapping
    private RecommendationResponse mapToResponse(Recommendation recommendation) {
        RecommendationResponse response = new RecommendationResponse();

        response.setId(recommendation.getId());
        response.setUserId(recommendation.getUser().getId());
        response.setActivityId(recommendation.getActivity().getId());
        response.setImprovements(recommendation.getImprovements());
        response.setSuggestions(recommendation.getSuggestions());
        response.setSafety(recommendation.getSafety());

        return response;
    }

    // 📥 GET by User
    public List<RecommendationResponse> getUserRecommendation(String userId) {
        return recommendationRepository.findByUserId(userId)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    // 📥 GET by Activity
    public List<RecommendationResponse> getActivityRecommendation(String activityId) {
        return recommendationRepository.findByActivityId(activityId)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }
}