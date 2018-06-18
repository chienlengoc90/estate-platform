package com.estate.web.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.estate.constant.SystemConstant;
import com.estate.dto.UserDTO;
import com.estate.service.impl.UserService;
import com.estate.utils.DisplayTagUtils;

@Controller(value = "usersControllerOfAdmin")
public class UsersController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/admin/user/list", method = RequestMethod.GET)
	public ModelAndView getNews(@ModelAttribute(SystemConstant.MODEL) UserDTO model, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("admin/user/list");
		DisplayTagUtils.initSearchBean(request, model);
		List<UserDTO> news = userService.getUsers(model.getUserName(),
				new PageRequest(model.getPage() - 1, model.getMaxPageItems()));
		model.setListResult(news);
		model.setTotalItems(userService.getTotalItems(model.getUserName()));
		mav.addObject(SystemConstant.MODEL, model);
		return mav;
	}
}
