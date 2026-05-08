package com.project.fitness.service;

import com.project.fitness.dto.RegisterRequest;
import com.project.fitness.dto.UserResponse;
import com.project.fitness.model.User;
import com.project.fitness.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    public UserResponse register(RegisterRequest request){      //  Builder use karke object bana rahe haan
        User user = User.builder()           // “Request wali values User entity ch pao”
                .email(request.getEmail())
                .firstName(request.getFirstName())
                .lastName((request.getLastName()))
                .password(request.getPassword())
                .build();
        User savedUser = userRepository.save(user);
        return mapToResponse(savedUser);

    }
    private UserResponse mapToResponse(User savedUser){
        UserResponse response = new UserResponse();
        response.setId((savedUser.getId()));
        response.setEmail(savedUser.getEmail());
        response.setFirstName(savedUser.getFirstName());
        response.setLastName(savedUser.getLastName());
        response.setCreatedAt(savedUser.getCreatedAt());
        response.setUpdatedAt(savedUser.getUpdatedAt());
        return response;
    }

}
// DTO mapping is used to separate input, database, and output layers for security, flexibility, and clean architecture.
// Service request nu entity ch convert karke DB ch save karda, fer entity nu response DTO ch convert karke return karda.
