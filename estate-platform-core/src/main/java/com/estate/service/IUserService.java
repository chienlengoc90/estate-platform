package com.estate.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Pageable;

import com.estate.dto.RoleDTO;
import com.estate.dto.UserDTO;

public interface IUserService {
	UserDTO findOneByUserName(String userName);
	UserDTO findNewsById(long id);
	void delete(long id);
	List<UserDTO> getUsers(String userName, Pageable pageable);
	int getTotalItems(String userName);
	UserDTO insert(UserDTO userDTO);
	UserDTO update(Long id, UserDTO userDTO);
	Map<String,String> getRoles();
}
