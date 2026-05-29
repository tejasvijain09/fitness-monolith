package com.project.fitness.repository;

import com.project.fitness.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
    User findByEmail(String email);
}

 //<,> Generics define the entity type and its ID type, ensuring type safety and proper method behavior.

