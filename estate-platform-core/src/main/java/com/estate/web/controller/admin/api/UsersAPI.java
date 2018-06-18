package com.estate.web.controller.admin.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estate.service.IUserService;

@RestController
@RequestMapping("/ajax/users")
public class UsersAPI {

	@Autowired
	private IUserService userService;
	
	@DeleteMapping
	public ResponseEntity<Void> deleteNews(@RequestBody long[] idList) {
		try {
			if (idList.length > 0) {
				for (long id : idList) {
					if (userService.findNewsById(id) != null) {
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
