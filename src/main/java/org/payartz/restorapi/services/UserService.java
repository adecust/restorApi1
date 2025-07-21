package org.payartz.restorapi.services;

import org.payartz.restorapi.model.request.UserRequest;
import org.payartz.restorapi.model.response.UserResponse;

public interface UserService {
    UserResponse createUser(UserRequest request);
    UserResponse getUserById(Long id);
    UserResponse updateUser(Long id, UserRequest request);
    void deleteUser(Long id);
}