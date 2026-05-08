package com.project.fitness.controller;

import com.project.fitness.dto.ActivityRequest;
import com.project.fitness.dto.ActivityResponse;
import com.project.fitness.service.ActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/activities")
@RequiredArgsConstructor
public class ActivityController {

    private final ActivityService activityService;

    @PostMapping
    public ResponseEntity<ActivityResponse> trackActivity( @RequestBody ActivityRequest request){
        return ResponseEntity.ok(activityService.trackActivity(request));
    }

    @GetMapping
    public ResponseEntity<List<ActivityResponse>> getUserActivities(
           @RequestHeader(value = "X-User-ID") String userId // “Header ch jis key da naam X-User-ID hai, ohdi value le”
           // Request de header chon X-User-ID di value leke String userId variable ch store karo”
    ){
        return ResponseEntity.ok(activityService.getUserActivities(userId));
    }
}

//@RequestHeader is used to extract values from HTTP request headers.
// Header chon userId lao, service nu do, te user diyan activities wapas bhejo
