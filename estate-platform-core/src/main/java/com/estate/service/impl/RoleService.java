package com.estate.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estate.converter.RoleConverter;
import com.estate.core.entity.RoleEntity;
import com.estate.core.repository.RoleRepository;
import com.estate.dto.RoleDTO;
import com.estate.service.IRoleService;

@Service
public class RoleService implements IRoleService {
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private RoleConverter roleConverter;

	public List<RoleDTO> findAll() {
		List<RoleEntity> roleEntities = roleRepository.findAll();
		List<RoleDTO> list = new ArrayList<>();
		roleEntities.forEach(item -> {
			RoleDTO roleDTO = roleConverter.convertToDto(item);
			list.add(roleDTO);
		});
		return list;
	}

}
