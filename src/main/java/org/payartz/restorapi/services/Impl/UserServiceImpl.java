package org.payartz.restorapi.services.Impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.payartz.restorapi.model.converter.UserConverter;
import org.payartz.restorapi.model.entity.User;
import org.payartz.restorapi.model.request.UserRequest;
import org.payartz.restorapi.model.response.UserResponse;
import org.payartz.restorapi.repository.UserRepository;
import org.payartz.restorapi.services.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserConverter userConverter;

    @Override
    public UserResponse createUser(UserRequest request) {
        User user = userConverter.dtoToEntity(request);
        User saved = userRepository.save(user);
        return userConverter.entityToResponse(saved);
    }

    @Override
    @Transactional(readOnly = true)
    public UserResponse getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Kullanıcı bulunamadı: " + id));
        return userConverter.entityToResponse(user);
    }

    @Override
    public UserResponse updateUser(Long id, UserRequest request) {
        User existing = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Kullanıcı bulunamadı: " + id));

        User updated = userConverter.dtoToEntity(request);
        updated.setId(existing.getId());
        updated.setCreatedAt(existing.getCreatedAt());

        User saved = userRepository.save(updated);
        return userConverter.entityToResponse(saved);
    }

    @Override
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new EntityNotFoundException("Kullanıcı bulunamadı: " + id);
        }
        userRepository.deleteById(id);
    }
}
