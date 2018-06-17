package com.estate.security;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.estate.constant.CustomMessages;
import com.estate.constant.SystemConstant;
import com.estate.utils.DisplayTagUtils;
import com.estate.utils.SecurityUtils;

@Component
public class CustomSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
	
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	private static final Logger log = Logger.getLogger(DisplayTagUtils.class);

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException {
		String targetUrl = determineTargetUrl(authentication);
		if (response.isCommitted()) {
			log.error(CustomMessages.ERR_NOT_REDIRECT);
			return;
		}
		redirectStrategy.sendRedirect(request, response, targetUrl);
	}

	public String determineTargetUrl(Authentication authentication) {
		String url = "";
		List<String> roles = SecurityUtils.getAuthorities();
		if (isUser(roles)) {
			url = SystemConstant.WEB_HOME_PAGE;
		} else if (isAdmin(roles)) {			
			url = SystemConstant.ADMIN_HOME_PAGE;
		} 
		return url;
	}

	public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
		this.redirectStrategy = redirectStrategy;
	}

	public RedirectStrategy getRedirectStrategy() {
		return redirectStrategy;
	}

	private boolean isAdmin(List<String> roles) {
		if (roles.contains(SystemConstant.ROLE_MANAGER)) {
			return true;
		}
		return false;
	}

	private boolean isUser(List<String> roles) {
		if (roles.contains(SystemConstant.ROLE_USER)) {
			return true;
		}
		return false;
	}
}
