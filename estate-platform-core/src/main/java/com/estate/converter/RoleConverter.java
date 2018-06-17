package com.estate.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.estate.core.entity.RoleEntity;
import com.estate.dto.RoleDTO;

@Component
public class RoleConverter {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public RoleDTO convertToDto(RoleEntity entity) {
		RoleDTO result = modelMapper.map(entity, RoleDTO.class);
        return result;
    }

    public RoleEntity convertToEntity(RoleDTO dto) {
    	RoleEntity result = modelMapper.map(dto, RoleEntity.class);
        return result;
    }
}
