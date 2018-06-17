package com.estate.web.controller.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "homeOfWeb")
public class HomeController {

	@RequestMapping(value = "/home-page", method = RequestMethod.GET)
	public ModelAndView homePage() {
		ModelAndView mav = new ModelAndView("web/home");
		//mav.addObject(SystemConstant.MODEL, homeService.getHomeDetail());
		return mav;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loginPage() {
		ModelAndView mav = new ModelAndView("login");		
		return mav;
	}
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/home-page";
    }
	
	@RequestMapping(value="/access-denied", method = RequestMethod.GET)
    public String accessDenied() {
        return "redirect:/login?accessDenied";
    }
	
	@RequestMapping(value="/contact-us", method = RequestMethod.GET)
    public ModelAndView contactPage() {
		ModelAndView mav = new ModelAndView("web/contact");
		return mav;
    }
}
