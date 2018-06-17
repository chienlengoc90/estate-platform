package com.estate.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.estate.core.entity.UserEntity;
import com.estate.dto.UserDTO;

@Component
public class UserConverter {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public UserDTO convertToDto(UserEntity entity) {
        UserDTO result = modelMapper.map(entity, UserDTO.class);
        return result;
    }

    public UserEntity convertToEntity(UserDTO dto) {
        UserEntity result = modelMapper.map(dto, UserEntity.class);
        return result;
    }
}
