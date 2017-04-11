package com.niit.backend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.backend.dao.UserDAO;
import com.niit.backend.dao.UserDAOImpl;
import com.niit.backend.model.User;

@Configuration
@ComponentScan("com")
@EnableTransactionManagement
public class ApplicationContextConfig {
	@Bean(name="datasource")
	public DataSource getDataSource()
	{
		BasicDataSource datasource=new BasicDataSource();
		datasource.setDriverClassName("org.h2.Driver");
		datasource.setUrl("jdbc:h2:tcp://localhost/~/watches");
		datasource.setUsername("sa");
		datasource.setPassword("");
		System.out.println("Datasource");
		return datasource;
	}
	private Properties getHibernateProperties()
	{
		Properties prop=new Properties();
		prop.put("hibernate.show_sql", "true");
		prop.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		prop.put("hibernate.hbm2ddl.auto", "create");
		System.out.println("Hibernate Properties");
		return prop;
	}
	@Autowired
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory(DataSource datasource)
	{
		LocalSessionFactoryBuilder sessionBuilder=new LocalSessionFactoryBuilder(datasource);
		sessionBuilder.addProperties(getHibernateProperties());
		sessionBuilder.addAnnotatedClass(User.class);
		System.out.println("Session Factory");
		return sessionBuilder.buildSessionFactory();
	}
	@Autowired
	@Bean(name="transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
	{
		HibernateTransactionManager transactionManager=new HibernateTransactionManager(sessionFactory);
		System.out.println("Transaction Manager");
		return transactionManager;
	}
	@Autowired
	@Bean(name="userDAO")
	public UserDAO getUserDAO(SessionFactory sessionFactory)
	{
		System.out.println("user DAO");
		return new UserDAOImpl();
	}
	@Autowired
	@Bean(name="user")
	public User getUser()
	{
		System.out.println("user");
		return new User();
	}
}
