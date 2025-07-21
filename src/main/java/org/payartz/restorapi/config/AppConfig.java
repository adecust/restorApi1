package org.payartz.restorapi.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.payartz.restorapi.model.dto.*;
import org.payartz.restorapi.model.entity.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.getConfiguration()
                .setAmbiguityIgnored(true)
                .setMatchingStrategy(MatchingStrategies.STRICT);

        // DTO ➔ Entity dönüşümünde ID'yi skip et
        modelMapper.createTypeMap(MenuDTO.class, Menu.class)
                .addMappings(mapper -> mapper.skip(Menu::setId));
        modelMapper.createTypeMap(BranchDTO.class, Branch.class)
                .addMappings(mapper -> mapper.skip(Branch::setId));
        modelMapper.createTypeMap(UserDTO.class, User.class)
                .addMappings(mapper -> mapper.skip(User::setId));
        modelMapper.createTypeMap(MenuItemDTO.class, MenuItem.class)
                .addMappings(mapper -> mapper.skip(MenuItem::setId));
        modelMapper.createTypeMap(OrderItemDTO.class, OrderItem.class)
                .addMappings(mapper -> mapper.skip(OrderItem::setId));
        modelMapper.createTypeMap(OrderDTO.class, Order.class)
                .addMappings(mapper -> mapper.skip(Order::setId));
        modelMapper.createTypeMap(RestaurantDTO.class, Restaurant.class)
                .addMappings(mapper -> mapper.skip(Restaurant::setId));

        return modelMapper;
    }

}
