package com.bds.service;

import javax.sql.DataSource;

import com.bds.beans.LoginBean;
import com.bds.beans.RegiatrationBean;



public class ServiceImpl implements Service {
	
	private DataSource dataSource;
	
 
	/**
	 * @return the dataSource
	 */
	public DataSource getDataSource() {
		return dataSource;
	}

	/**
	 * @param dataSource the dataSource to set
	 */
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public LoginBean userLogin(LoginBean loginBean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String registerUser(RegiatrationBean regiatrationBean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String reSendEmail(RegiatrationBean regiatrationBean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String validateUser(RegiatrationBean regiatrationBean) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
