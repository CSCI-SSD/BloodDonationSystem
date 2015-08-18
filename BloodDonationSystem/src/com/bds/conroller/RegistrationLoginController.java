package com.bds.conroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import com.bds.beans.RegiatrationBean;
import com.bds.service.Service;
import com.bds.util.SystemConstants;

public class RegistrationLoginController extends SystemAbstractController {
	
	@Autowired
	private Service service;
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		ModelAndView modelAndView = null;
		
		String page = (String)request.getParameter("pageid");
		
		
		String resend = (String)request.getParameter("resend");
		RegiatrationBean regiatrationBean = new RegiatrationBean();
		regiatrationBean.setEmail((String)request.getParameter("email"));
		
		if (resend != null && resend.equals("true")) {
			
			String status = service.reSendEmail(regiatrationBean);
			modelAndView = new ModelAndView("registrationValidation");
			request.setAttribute(SystemConstants.MESSAGE, status);
			return modelAndView;
		}
		
		String uservalidation = ("uservalidation");
		if (uservalidation != null && uservalidation.equals(page)) {
			regiatrationBean.setCode(request.getParameter("code"));
			String status = service.validateUser(regiatrationBean);
			modelAndView = new ModelAndView("Login");
			request.setAttribute(SystemConstants.MESSAGE, status);
			return modelAndView;
		}
		
		
		
		regiatrationBean.setPassword((String)request.getParameter("password"));
		regiatrationBean.setFirstName((String)request.getParameter("firstname"));
		regiatrationBean.setLastName((String)request.getParameter("lastname"));
		regiatrationBean.setAdd1((String)request.getParameter("add1"));
		regiatrationBean.setAdd2((String)request.getParameter("add2"));
		regiatrationBean.setCity((String)request.getParameter("city"));
		regiatrationBean.setState((String)request.getParameter("state"));
		regiatrationBean.setPin(request.getParameter("zip"));
		regiatrationBean.setId(request.getParameter("id"));
		regiatrationBean.setPhone(request.getParameter("phone"));
		regiatrationBean.setBloodType(request.getParameter("bloodtype"));
		regiatrationBean.setHealthID(request.getParameter("id"));
		regiatrationBean.setGender(request.getParameter("gender"));
		regiatrationBean.setBloodType(request.getParameter("bloodtype"));
		
		String satus = "";
		
		if(page.equalsIgnoreCase(SystemConstants.PAGE_SEKER_REGISTRATION)) {
			
			regiatrationBean.setBloodType("ORG");
			regiatrationBean.setLastName("ORG");
			regiatrationBean.setUserType("SEKER");
			regiatrationBean.setGender("ORG");
			regiatrationBean.setHealthID("ORG");
			regiatrationBean.setOccupation("ORG");
			satus = service.registerSekerUser(regiatrationBean);
		} else if(page.equalsIgnoreCase(SystemConstants.PAGE_DONOR_REGISTRATION)) {
			regiatrationBean.setUserType("DONOR");
			regiatrationBean.setOccupation("DONOR");
			satus = service.registerDonorUser(regiatrationBean);
		}
		
		
		
		
		
		if (satus.equals(SystemConstants.REGISTRATION_SUCCESS)) {
			modelAndView = new ModelAndView("Login");
		} else {
			modelAndView = new ModelAndView("registration");
			request.setAttribute(SystemConstants.MESSAGE, "registrationFaild");
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
