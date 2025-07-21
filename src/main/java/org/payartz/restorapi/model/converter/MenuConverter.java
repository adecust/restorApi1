package org.payartz.restorapi.model.converter;

import org.payartz.restorapi.model.dto.MenuDTO;
import org.payartz.restorapi.model.entity.Branch;
import org.payartz.restorapi.model.entity.Menu;
import org.springframework.stereotype.Component;

@Component
public class MenuConverter {

    public Menu dtoToEntity(MenuDTO dto) {
        if (dto == null) {
            return null;
        }
        Menu entity = new Menu();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());

        if (dto.getBranchId() != null) {
            Branch branch = new Branch();
            branch.setId(dto.getBranchId());
            entity.setBranch(branch);
        } else {
            entity.setBranch(null);
        }

        entity.setCreatedAt(dto.getCreatedAt());
        return entity;
    }

    public MenuDTO entityToDto(Menu entity) {
        if (entity == null) {
            return null;
        }
        MenuDTO dto = new MenuDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());

        if (entity.getBranch() != null) {
            dto.setBranchId(entity.getBranch().getId());
        } else {
            dto.setBranchId(null);
        }

        dto.setCreatedAt(entity.getCreatedAt());
        return dto;
    }
}
