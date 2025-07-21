package org.payartz.restorapi.model.converter;

import org.payartz.restorapi.model.entity.User;
import org.payartz.restorapi.model.request.UserRequest;
import org.payartz.restorapi.model.response.UserResponse;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class UserConverter {

    public User dtoToEntity(UserRequest request) {
        User user = new User();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setPhoneNumber(request.getPhoneNumber());
        user.setUserType(request.getUserType());
        user.setCreatedAt(LocalDateTime.now());
        return user;
    }

    public UserResponse entityToResponse(User user) {
        UserResponse response = new UserResponse();
        response.setId(user.getId());
        response.setFirstName(user.getFirstName());
        response.setLastName(user.getLastName());
        response.setEmail(user.getEmail());
        response.setPhoneNumber(user.getPhoneNumber());
        response.setUserType(user.getUserType());
        response.setCreatedAt(user.getCreatedAt());
        return response;
    }
}

