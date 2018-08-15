package com.stc.cfgs;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import com.nt.model.StudentHLO;
import com.stc.dto.Student;



@Configuration
@ComponentScan(basePackages={"com.stc.dao"})
public class PersistenceConfig {
		@Autowired
		private DataSource ds;
		
		@Bean(autowire=Autowire.BY_TYPE)
		public LocalSessionFactoryBean  createLocalSessionFactoryBean(){
			Properties props=null;
			LocalSessionFactoryBean localSesFact=null;
			localSesFact=new LocalSessionFactoryBean();
			//localSesFact.setDataSource(ds);
			localSesFact.setAnnotatedClasses(StudentHLO.class);
			localSesFact.setAnnotatedPackages("com.stc.model");
			props=new Properties();
			props.put("hibernate.show_sql", "true");
			props.put("hibernate.format_sql", "true");
			props.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
			localSesFact.setHibernateProperties(props);
			return localSesFact;
		}
		
		@Bean
		@Primary
		public  SessionFactory createSessionFactory(){
			 return  createLocalSessionFactoryBean().getObject();
		}
		
		@Bean(autowire=Autowire.BY_TYPE)
		public  HibernateTemplate  createHibernateTemplate(){
			return new HibernateTemplate();
		}
}
