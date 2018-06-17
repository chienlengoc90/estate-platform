package com.estate.web.controller.admin.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.estate.constant.SystemConstant;
import com.estate.dto.UserDTO;
import com.estate.service.IRoleService;
import com.estate.service.IUserService;

@RestController
@RequestMapping("/ajax/users")
public class UsersAPI {

	@Autowired
	private IUserService userService;
	
	@Autowired
	private IRoleService roleService;

	@GetMapping
	public ModelAndView editNewsPage() {
		ModelAndView mav = new ModelAndView("admin/user/edit");
		UserDTO userDTO = new UserDTO();
		userDTO.setRoles(roleService.findAll());
		mav.addObject(SystemConstant.MODEL, userDTO);
		return mav;
	}

	@GetMapping("/{id}")
	public ModelAndView editNewsPageByID() {
		ModelAndView mav = new ModelAndView("admin/user/edit");
		UserDTO userDTO = new UserDTO();
		// news.setCategories(categoryService.getCategories());
		mav.addObject(SystemConstant.MODEL, userDTO);
		return mav;
	}



	/*
	 * @PutMapping("/{id}") public ResponseEntity<NewsDTO>
	 * updateNews(@PathVariable("id") long id, @RequestBody NewsDTO newsDTO) {
	 * return ResponseEntity.ok(newsService.update(id, newsDTO)); // return new
	 * }
	 */

	// @DeleteMapping("/{id}")
	// public ResponseEntity deleteNews(@PathVariable("id") long id) {
	// if (newsService.findNewsById(id) == null) {
	// // log
	// return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	// }
	// newsService.delete(id);
	// return ResponseEntity.ok();
	// return new ResponseEntity.ok(id);
	// }
	//
	// @DeleteMapping
	// public ResponseEntity<Void> deleteNews(@RequestBody long[] id) {
	// try {
	// if (id.length > 0) {
	// for (long l : id) {
	// if (newsService.findNewsById(l) != null) {
	// newsService.delete(l);
	// }
	// }
	// return ResponseEntity.noContent().build();
	// } else {
	// return ResponseEntity.notFound().build();
	// }
	// } catch (IllegalArgumentException e) {
	// return ResponseEntity.notFound().build();
	// }
	// }
}
