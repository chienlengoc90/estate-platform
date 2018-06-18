package com.estate.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.estate.constant.CustomMessages;
import com.estate.dto.MyUserDetail;
import com.estate.dto.RoleDTO;
import com.estate.dto.UserDTO;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	private final Logger log = Logger.getLogger(CustomUserDetailsService.class);

	@Autowired
	private UserService userService;

	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String userName) {
		UserDTO userDTO = userService.findOneByUserName(userName);

		if (userDTO == null) {
			log.error(CustomMessages.ERR_USER_NOT_FOUND);
			throw new UsernameNotFoundException(CustomMessages.ERR_USER_NOT_FOUND);
		}
		if (userDTO.getStatus()== 0){
			log.error(CustomMessages.ERR_USER_NOT_FOUND);
			throw new UsernameNotFoundException(CustomMessages.ERR_USER_IS_DELETED);
		}
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (RoleDTO role : userDTO.getRoles()) {
			authorities.add(new SimpleGrantedAuthority(role.getCode()));
		}

		MyUserDetail myUserDetail = new MyUserDetail(userName, userDTO.getPassword(), true, true, true, true,
				authorities);
		BeanUtils.copyProperties(userDTO, myUserDetail);
		return myUserDetail;
	}
}
