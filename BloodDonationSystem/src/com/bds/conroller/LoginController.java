package com.bds.conroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bds.beans.LoginBean;
import com.bds.service.Service;
import com.bds.util.SystemConstants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

public class LoginController extends SystemAbstractController {
	
	@Autowired
	private Service service;
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		LoginBean loginBean = new LoginBean();
		loginBean.setUserName((String)request.getParameter("userName"));
		loginBean.setPassword((String)request.getParameter("password"));
		
		service.userLogin(loginBean);
		ModelAndView modelAndView = null;
		if (loginBean.getStatus() != null && loginBean.getStatus().equalsIgnoreCase("SUCCESS")) {
			modelAndView = new ModelAndView("mainPage");
			request.getSession().setAttribute(SystemConstants.LOGIN_DETAILS, loginBean);
		} else if (loginBean.getStatus() != null && loginBean.getStatus().equalsIgnoreCase("REQUIRED")) {
			modelAndView = new ModelAndView("validation");
			modelAndView.addObject(SystemConstants.MESSAGE, "Validate");
		} else {
			modelAndView = new ModelAndView("Login");
			modelAndView.addObject(SystemConstants.MESSAGE, "Invalied Login");
			
		}
		return modelAndView;
	}

	/**
	 * @return the service
	 */
	public Service getService() {
		return service;
	}

	/**
	 * @param service the service to set
	 */
	public void setService(Service service) {
		this.service = service;
	}

}
