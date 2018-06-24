package com.estate.controller.admin.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estate.dto.UserDTO;
import com.estate.service.IUserService;

@RestController
@RequestMapping("/ajax/user")
public class UserAPI {

	@Autowired
	private IUserService userService;
	
	@PostMapping
	public ResponseEntity<UserDTO> createUsers(@RequestBody UserDTO newUser) {
		return ResponseEntity.ok(userService.insert(newUser));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<UserDTO> updateUsers(@PathVariable("id") long id, @RequestBody UserDTO userDTO) {
		return ResponseEntity.ok(userService.update(id, userDTO));
	}
	
	@DeleteMapping
	public ResponseEntity<Void> deleteNews(@RequestBody long[] idList) {
		try {
			if (idList.length > 0) {
				for (long id : idList) {
					if (userService.findUserById(id) != null) {
						userService.delete(id);
					}
				}
				return ResponseEntity.noContent().build();
			} else {
				return ResponseEntity.notFound().build();
			}
		} catch (IllegalArgumentException e) {
			return ResponseEntity.notFound().build();
		}
	}
}
