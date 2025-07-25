package org.payartz.restorapi.services.Impl;

import lombok.RequiredArgsConstructor;
import org.payartz.restorapi.exception.ErrorCode;
import org.payartz.restorapi.exception.exceptions.ResourceNotFoundException;
import org.payartz.restorapi.model.converter.MenuConverter;
import org.payartz.restorapi.model.dto.MenuDTO;
import org.payartz.restorapi.model.entity.Branch;
import org.payartz.restorapi.model.entity.Menu;
import org.payartz.restorapi.model.request.MenuRequest;
import org.payartz.restorapi.model.response.MenuResponse;
import org.payartz.restorapi.repository.MenuRepository;
import org.payartz.restorapi.services.MenuService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Transactional
public class MenuServiceImpl implements MenuService {

    private final MenuRepository menuRepository;
    private final MenuConverter menuConverter;

    @Override
    public MenuResponse createMenu(MenuRequest request) {
        MenuDTO dto = new MenuDTO();
        dto.setName(request.getName());
        dto.setDescription(request.getDescription());
        dto.setBranchId(request.getBranchId());
        dto.setCreatedAt(LocalDateTime.now());
        Menu entity = menuConverter.dtoToEntity(dto);
        Menu saved = menuRepository.save(entity);
        MenuDTO savedDto = menuConverter.entityToDto(saved);
        MenuResponse response = new MenuResponse();
        response.setId(savedDto.getId());
        response.setName(savedDto.getName());
        response.setDescription(savedDto.getDescription());
        response.setBranchId(savedDto.getBranchId());
        response.setCreatedAt(savedDto.getCreatedAt());
        return response;
    }

    @Override
    @Transactional(readOnly = true)
    public MenuResponse getMenuById(Long id) {
        Menu entity = menuRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ErrorCode.MENU_NOT_FOUND, "Menü bulunamadı: " + id));
        MenuDTO dto = menuConverter.entityToDto(entity);
        MenuResponse response = new MenuResponse();
        response.setId(dto.getId());
        response.setName(dto.getName());
        response.setDescription(dto.getDescription());
        response.setBranchId(dto.getBranchId());
        response.setCreatedAt(dto.getCreatedAt());
        return response;
    }

    @Override
    public MenuResponse updateMenu(Long id, MenuRequest request) {
        Menu entity = menuRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ErrorCode.MENU_NOT_FOUND, "Menü bulunamadı: " + id));
        entity.setName(request.getName());
        entity.setDescription(request.getDescription());
        if (request.getBranchId() != null) {
            Branch branch = new Branch();
            branch.setId(request.getBranchId());
            entity.setBranch(branch);
        }
        Menu updated = menuRepository.save(entity);
        MenuDTO updatedDto = menuConverter.entityToDto(updated);
        MenuResponse response = new MenuResponse();
        response.setId(updatedDto.getId());
        response.setName(updatedDto.getName());
        response.setDescription(updatedDto.getDescription());
        response.setBranchId(updatedDto.getBranchId());
        response.setCreatedAt(updatedDto.getCreatedAt());
        return response;
    }

    @Override
    public void deleteMenu(Long id) {
        if (!menuRepository.existsById(id)) {
            throw new ResourceNotFoundException(ErrorCode.MENU_NOT_FOUND, "Menü bulunamadı: " + id);
        }
        menuRepository.deleteById(id);
    }
}
