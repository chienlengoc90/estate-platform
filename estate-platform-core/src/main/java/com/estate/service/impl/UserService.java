package com.estate.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.estate.converter.UserConverter;
import com.estate.core.entity.UserEntity;
import com.estate.core.repository.UserRepository;
import com.estate.dto.UserDTO;
import com.estate.service.IUserService;

@Service
public class UserService implements IUserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserConverter userConverter;

	@Override
	public UserDTO findOneByUserName(String userName) {
		UserEntity userEntity = userRepository.findOneByUserName(userName);
		UserDTO userDTO = userConverter.convertToDto(userEntity);
		return userDTO;
	}

	@Override
	public List<UserDTO> getUsers(String userName, Pageable pageable) {
		Page<UserEntity> newsPage = null;
		if (userName != null) {
			newsPage = userRepository.findByUserNameContainingIgnoreCase(userName, pageable);
		} else {
			newsPage = userRepository.findAll(pageable);
		}
		List<UserEntity> newsEntities = newsPage.getContent();
		List<UserDTO> result = new ArrayList<UserDTO>();
		for (UserEntity userEntity : newsEntities) {
			UserDTO userDTO = userConverter.convertToDto(userEntity);
			result.add(userDTO);
		}
		return result;
	}

	@Override
	public int getTotalItems(String userName) {
		int totalItem = 0;
		if (userName != null) {
			totalItem = (int) userRepository.countByUserNameContainingIgnoreCase(userName);
		} else {
			totalItem = (int) userRepository.count();
		}
		return totalItem;
	}

	@Override
	public UserDTO insert(UserDTO userDTO) {
		UserEntity userEntity = userConverter.convertToEntity(userDTO);
		userEntity = userRepository.save(userEntity);
		return userConverter.convertToDto(userEntity);
	}

	@Override
	public UserDTO findNewsById(long id) {
		UserEntity entity = userRepository.findOne(id);
		UserDTO dto = userConverter.convertToDto(entity);	
		return dto;
	}

	@Override
	public void delete(long id) {
		UserEntity userEntity = userRepository.findOne(id);
		userEntity.setStatus(0);
		userRepository.save(userEntity);
	}
}
