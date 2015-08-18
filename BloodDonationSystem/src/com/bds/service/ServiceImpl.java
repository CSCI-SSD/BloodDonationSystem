package com.bds.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.sql.DataSource;

import com.bds.beans.LoginBean;
import com.bds.beans.RegiatrationBean;
import com.bds.util.SystemConstants;



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
		Connection connection = null;
		Statement statement = null;
		
		try {
			connection = dataSource.getConnection();
			statement = connection.createStatement();
			String query = "SELECT LASTNAME, EMAIL, PASSWORD, STATUS, USERTYPE from USERDETAILS where EMAIL ='"+loginBean.getUserName()+"'";
			ResultSet rs = statement.executeQuery(query);
			if (rs.next()) {
				String password = rs.getString("PASSWORD");
				String status = rs.getString("STATUS");
				
				loginBean.setLastName(rs.getString("LASTNAME"));
				loginBean.setType(rs.getString("USERTYPE"));
				
				if(password.equals(loginBean.getPassword())) {
					loginBean.setStatus(status);
				} else {
					loginBean.setStatus(null);	
				}
			}
			
		} catch (SQLException sqlException) {
			loginBean.setStatus(null);	
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return loginBean;
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
		Connection connection = null;
		Statement statement = null;
		
		try {
			connection = dataSource.getConnection();
			statement = connection.createStatement();
			String query = "SELECT * from LOGINDETAILS where EMAIL ='"+regiatrationBean.getEmail()+"'";
			ResultSet rs = statement.executeQuery(query);
			if (rs.next()) {
				String status = rs.getString("STATUS");
				int code = rs.getInt("code");
				
				if (status != null && status.equals("REQUIRED") && code == Integer.parseInt(regiatrationBean.getCode()) ) {
					
					PreparedStatement preparedStatement = connection.prepareStatement("UPDATE LOGINDETAILS SET status='SUCCESS', VALIDATIONSTATUS='SUCCESS' where EMail = ?");
					preparedStatement.setString(1, regiatrationBean.getEmail());
					
					int state = preparedStatement.executeUpdate();

					preparedStatement = connection.prepareStatement("UPDATE USERDETAILS SET STATUS ='SUCCESS' where EMail = ?");
					preparedStatement.setString(1, regiatrationBean.getEmail());
					
					int state1 = preparedStatement.executeUpdate();
					
					if (state == 1 && state1 == 1)  {
						
						
						Properties props = new Properties();
						props.put("mail.smtp.host", "smtp.gmail.com");
						props.put("mail.smtp.socketFactory.port", "465");
						props.put("mail.smtp.socketFactory.class",
								"javax.net.ssl.SSLSocketFactory");
						props.put("mail.smtp.auth", "true");
						props.put("mail.smtp.port", "465");
				 
						Session session = Session.getDefaultInstance(props,
							new javax.mail.Authenticator() {
								protected PasswordAuthentication getPasswordAuthentication() {
									return new PasswordAuthentication("ssd.project.crm@gmail.com","qwerQWER1234");
								}
							});
				 
						try {
				 
							Message message = new MimeMessage(session);
							message.setFrom(new InternetAddress("ssd.project.crm@gmail.com"));
							message.setRecipients(Message.RecipientType.TO,
									InternetAddress.parse(regiatrationBean.getEmail()));
							message.setSubject("Crime Management System Account Validation");
							message.setText("Dear User, "+
									" \n\n Registration process is Successfull. \n\n Thanks\nCrime ManagementSystem");
				 
							Transport.send(message);
				 
							System.out.println("Email sent sucessfull");
				 
						} catch (MessagingException e) {
							System.out.println("Email sent un sucessfull");
							throw new RuntimeException(e);
						}
						
						
						
						return "ValidatedUser";
					} else {
						return "NotValidatedUser";
					}
					
				} else {
					return "NotValidatedUser";
				}
			} 
			
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		} catch (NumberFormatException numberFormatException) {
			numberFormatException.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return "NotValidatedUser";
	}
	

	@Override
	public String registerSekerUser(RegiatrationBean regiatrationBean) {
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = dataSource.getConnection();
			
			statement = connection.prepareStatement("INSERT INTO USERDETAILS "
					+ "(EMAIL, ID,"
					+ " FIRSTNAME, "
					+ "LASTNAME, "
					+ "DATEOFBIRTH, "
					+ "OCCUPATION,"
					+ " ADDRESS1, "
					+ "ADDRESS2, "
					+ "CITY, "
					+ "STATE, "
					+ "ZIP, "
					+ "PASSWORD,"
					+ "GENDER, "
					+ "PHONE,"
					+ "BLOODTYPE, "
					+ "USERTYPE,"
					+ "STATUS) VALUES (?,?,?,?,?,?,?,?,?,?,?,?, ?,?,?,?,?)");
			statement.setString(1, regiatrationBean.getEmail());
			statement.setString(2, regiatrationBean.getId());
			statement.setString(3, regiatrationBean.getFirstName());
			statement.setString(4, regiatrationBean.getLastName());
			statement.setDate(5, new java.sql.Date(System.currentTimeMillis()));
			statement.setString(6, regiatrationBean.getOccupation());
			statement.setString(7, regiatrationBean.getAdd1());
			statement.setString(8, regiatrationBean.getAdd2());
			statement.setString(9, regiatrationBean.getCity());
			statement.setString(10, regiatrationBean.getState());
			statement.setString(11, regiatrationBean.getPin());
			statement.setString(12, regiatrationBean.getPassword());
			statement.setString(13, regiatrationBean.getGender());
			statement.setString(14, regiatrationBean.getPhone());
			statement.setString(15, regiatrationBean.getBloodType());
			statement.setString(16, regiatrationBean.getUserType());
			statement.setString(17, "REQUIRED");
			int satus = statement.executeUpdate();
			
			Random random = new Random();
			StringBuilder sb = new StringBuilder(6);
		    for(int i=0; i < 6; i++)
		        sb.append((char)('0' + random.nextInt(10)));
		    
		    int randomNumber = Integer.parseInt(sb.toString());
			
			statement = connection.prepareStatement("INSERT INTO LOGINDETAILS (EMAIL, PASSWORD, STATUS, VALIDATIONSTATUS, CODE) VALUES (?,?,?,?,?)");
			statement.setString(1, regiatrationBean.getEmail());
			statement.setString(2, regiatrationBean.getPassword());
			statement.setInt(5, randomNumber);
			statement.setString(4, "REQUIRED");
			statement.setString(3, "REQUIRED");
			
			emailGeneration(regiatrationBean.getEmail(), randomNumber, regiatrationBean.getLastName());
			
			int status1 = statement.executeUpdate();
			
			if (satus==1 && status1 == 1) {
				return SystemConstants.REGISTRATION_SUCCESS;
			} else {
				return SystemConstants.REGISTRATION_UNSUCCESS;
			}
			
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return SystemConstants.REGISTRATION_UNSUCCESS;
	}
	
	private void emailGeneration(String email, Integer randomNumber,
			String lastName) {

		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(
								"ssd.project.crm@gmail.com", "qwerQWER1234");
					}
				});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("ssd.project.crm@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(email));
			message.setSubject("Crime Management System Account Validation");
			message.setText("Dear "
					+ lastName
					+ ","
					+ " \n\n Please enter validation code "
					+ randomNumber
					+ " To complete the registration process \n\n Thanks\nCrime ManagementSystem");

			Transport.send(message);

			System.out.println("Email sent sucessfull");

		} catch (MessagingException e) {
			System.out.println("Email sent un sucessfull");
			throw new RuntimeException(e);
		}
	}

	@Override
	public String registerDonorUser(RegiatrationBean regiatrationBean) {

		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = dataSource.getConnection();
			
			statement = connection.prepareStatement("INSERT INTO USERDETAILS "
					+ "(EMAIL, ID,"
					+ " FIRSTNAME, "
					+ "LASTNAME, "
					+ "DATEOFBIRTH, "
					+ "OCCUPATION,"
					+ " ADDRESS1, "
					+ "ADDRESS2, "
					+ "CITY, "
					+ "STATE, "
					+ "ZIP, "
					+ "PASSWORD,"
					+ "GENDER, "
					+ "PHONE,"
					+ "BLOODTYPE, "
					+ "USERTYPE,"
					+ "STATUS) VALUES (?,?,?,?,?,?,?,?,?,?,?,?, ?,?,?,?,?)");
			statement.setString(1, regiatrationBean.getEmail());
			statement.setString(2, regiatrationBean.getId());
			statement.setString(3, regiatrationBean.getFirstName());
			statement.setString(4, regiatrationBean.getLastName());
			statement.setDate(5, new java.sql.Date(System.currentTimeMillis()));
			statement.setString(6, regiatrationBean.getOccupation());
			statement.setString(7, regiatrationBean.getAdd1());
			statement.setString(8, regiatrationBean.getAdd2());
			statement.setString(9, regiatrationBean.getCity());
			statement.setString(10, regiatrationBean.getState());
			statement.setString(11, regiatrationBean.getPin());
			statement.setString(12, regiatrationBean.getPassword());
			statement.setString(13, regiatrationBean.getGender());
			statement.setString(14, regiatrationBean.getPhone());
			statement.setString(15, regiatrationBean.getBloodType());
			statement.setString(16, regiatrationBean.getUserType());
			statement.setString(17, "REQUIRED");
			int satus = statement.executeUpdate();
			
			Random random = new Random();
			StringBuilder sb = new StringBuilder(6);
		    for(int i=0; i < 6; i++)
		        sb.append((char)('0' + random.nextInt(10)));
		    
		    int randomNumber = Integer.parseInt(sb.toString());
			
			statement = connection.prepareStatement("INSERT INTO LOGINDETAILS (EMAIL, PASSWORD, STATUS, VALIDATIONSTATUS, CODE) VALUES (?,?,?,?,?)");
			statement.setString(1, regiatrationBean.getEmail());
			statement.setString(2, regiatrationBean.getPassword());
			statement.setInt(5, randomNumber);
			statement.setString(4, "REQUIRED");
			statement.setString(3, "REQUIRED");
			
			emailGeneration(regiatrationBean.getEmail(), randomNumber, regiatrationBean.getLastName());
			
			int status1 = statement.executeUpdate();
			
			if (satus==1 && status1 == 1) {
				return SystemConstants.REGISTRATION_SUCCESS;
			} else {
				return SystemConstants.REGISTRATION_UNSUCCESS;
			}
			
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return SystemConstants.REGISTRATION_UNSUCCESS;
	
	}
	
}
