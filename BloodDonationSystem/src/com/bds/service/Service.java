package com.bds.service;

import com.bds.beans.LoginBean;
import com.bds.beans.RegiatrationBean;

public interface Service {
	
	public LoginBean userLogin(LoginBean loginBean);
	
	public String registerUser(RegiatrationBean regiatrationBean);

	public String reSendEmail(RegiatrationBean regiatrationBean);

	public String validateUser(RegiatrationBean regiatrationBean);

}
