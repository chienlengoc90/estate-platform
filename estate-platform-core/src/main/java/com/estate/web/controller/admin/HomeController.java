package com.estate.web.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "homeOfAdmin")
public class HomeController {
	
//	@Autowired
//	private UserRepository userRepository;

	@RequestMapping(value = "/admin/home", method = RequestMethod.GET)
	public ModelAndView homePage() {
		ModelAndView mav = new ModelAndView("admin/home");
		/*mav.addObject("user", userRepository.findOneByUserName(SystemConstant.ROLE_ADMIN));*/
		return mav;
	}
}
