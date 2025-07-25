package org.payartz.restorapi.services.Impl;

import lombok.RequiredArgsConstructor;
import org.payartz.restorapi.exception.ErrorCode;
import org.payartz.restorapi.exception.exceptions.DuplicateResourceException;
import org.payartz.restorapi.exception.exceptions.InvalidInputException;
import org.payartz.restorapi.exception.exceptions.ResourceNotFoundException;
import org.payartz.restorapi.model.converter.UserConverter;
import org.payartz.restorapi.model.entity.User;
import org.payartz.restorapi.model.request.UserRequest;
import org.payartz.restorapi.model.response.UserResponse;
import org.payartz.restorapi.repository.UserRepository;
import org.payartz.restorapi.services.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserConverter userConverter;

    @Override
    public UserResponse createUser(UserRequest request) {
        if (Objects.isNull(request.getEmail()) || Objects.isNull(request.getFirstName()) || Objects.isNull(request.getLastName())) {
            throw new InvalidInputException(ErrorCode.INVALID_INPUT.getMessage());
        }
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new DuplicateResourceException(ErrorCode.DUPLICATE_RESOURCE.getMessage() + " (email: " + request.getEmail() + ")");
        }

        User user = userConverter.dtoToEntity(request);
        User saved = userRepository.save(user);
        return userConverter.entityToResponse(saved);
    }

    @Override
    @Transactional(readOnly = true)
    public UserResponse getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ErrorCode.USER_NOT_FOUND, "Kullanıcı bulunamadı: " + id));
        return userConverter.entityToResponse(user);
    }

    @Override
    public UserResponse updateUser(Long id, UserRequest request) {
        if (Objects.isNull(request.getEmail()) || Objects.isNull(request.getFirstName()) || Objects.isNull(request.getLastName())) {
            throw new InvalidInputException(ErrorCode.INVALID_INPUT.getMessage());
        }
        User existing = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ErrorCode.USER_NOT_FOUND, "Güncellenmek istenen kullanıcı bulunamadı: " + id));

        boolean emailUsed = userRepository.existsByEmail(request.getEmail()) && !existing.getEmail().equals(request.getEmail());
        if (emailUsed) {
            throw new DuplicateResourceException(ErrorCode.DUPLICATE_RESOURCE.getMessage() + " (email: " + request.getEmail() + ")");
        }

        User updated = userConverter.dtoToEntity(request);
        updated.setId(existing.getId());
        updated.setCreatedAt(existing.getCreatedAt());
        User saved = userRepository.save(updated);
        return userConverter.entityToResponse(saved);
    }

    @Override
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new ResourceNotFoundException(ErrorCode.USER_NOT_FOUND, "Silinmek istenen kullanıcı bulunamadı: " + id);
        }
        userRepository.deleteById(id);
    }
}
