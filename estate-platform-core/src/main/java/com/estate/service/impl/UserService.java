package com.estate.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.estate.converter.UserConverter;
import com.estate.core.entity.RoleEntity;
import com.estate.core.entity.UserEntity;
import com.estate.core.repository.RoleRepository;
import com.estate.core.repository.UserRepository;
import com.estate.dto.UserDTO;
import com.estate.service.IUserService;

@Service("IUserService")
public class UserService implements IUserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserConverter userConverter;
	
	@Autowired
	private RoleRepository roleRepository;

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
	@Transactional
	public UserDTO insert(UserDTO newUser) {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		RoleEntity role = roleRepository.findOneByCode(newUser.getRoleCode());
		List<RoleEntity> roles = new ArrayList<>();
		roles.add(role);
		UserEntity userEntity = userConverter.convertToEntity(newUser);
		userEntity.setRoles(roles);
		userEntity.setStatus(1);
		userEntity.setPassword(passwordEncoder.encode(newUser.getPassword()));
		return userConverter.convertToDto(userRepository.save(userEntity));
	}

	@Override
	public UserDTO findUserById(long id) {
		UserEntity entity = userRepository.findOne(id);
		List<RoleEntity> roles = entity.getRoles();
		UserDTO dto = userConverter.convertToDto(entity);
		roles.forEach(item ->{
			dto.setRoleCode(item.getCode());
		});
		return dto;
	}

	@Override
	public void delete(long id) {
		UserEntity userEntity = userRepository.findOne(id);
		userEntity.setStatus(0);
		userRepository.save(userEntity);
	}
	@Override
	@Transactional
	public UserDTO update(Long id, UserDTO updateUser) {
		RoleEntity role = roleRepository.findOneByCode(updateUser.getRoleCode());
		List<RoleEntity> roles = new ArrayList<>();
		roles.add(role);
		UserEntity oldUser = userRepository.findOne(id);
		oldUser.setEmail(updateUser.getEmail());
		oldUser.setFullName(updateUser.getFullName());
		oldUser.setPassword(updateUser.getPassword());
		oldUser.setPhoneNumber(updateUser.getPhoneNumber());
		oldUser.setStatus(1);
		oldUser.setRoles(roles);
		return userConverter.convertToDto(userRepository.save(oldUser));
	}
}
