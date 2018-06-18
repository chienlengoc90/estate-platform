package com.estate.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.estate.dto.UserDTO;

public interface IUserService {
	UserDTO findOneByUserName(String userName);
	UserDTO findNewsById(long id);
	void delete(long id);
	List<UserDTO> getUsers(String userName, Pageable pageable);
	int getTotalItems(String userName);
	UserDTO insert(UserDTO userDTO);
}
