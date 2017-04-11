package com.niit;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.backend.dao.UserDAO;
import com.niit.backend.model.User;

public class UserTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com");
		
	context.refresh();
	UserDAO userDAO=(UserDAO)context.getBean("userDAO");
	User user=(User)context.getBean("user");
	user.setUserid(1);
	user.setUsername("user1");
	user.setPassword("abcd");
	user.setAddress("Hyderabad");
	user.setEmailid("ss@yahoo.com");
	user.setEnabled("true");
	user.setRole("Admin");
	user.setPhno("123456789");
	userDAO.saveOrUpdate(user);
	System.out.println("user created");

	}

}
