package com.stc.cfgs;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@Configuration
@EnableTransactionManagement
public class AopConfig {
	 @Autowired
		private SessionFactory sesfact;
		
		@Bean(name="hbTxMgmr")
		public PlatformTransactionManager createHibernateTransactionManager(){
			return new HibernateTransactionManager(sesfact);
		}
	
}
