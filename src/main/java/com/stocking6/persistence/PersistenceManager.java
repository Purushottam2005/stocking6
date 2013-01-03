package com.stocking6.persistence;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebListener
public class PersistenceManager implements ServletContextListener {

	private static Logger logger = LoggerFactory.getLogger(PersistenceManager.class);
	
	@Override
	public void contextInitialized(ServletContextEvent event) {
		try{
			logger.info("Starting application and entity manager." );
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("stocking");
			EntityManager entityManager = factory.createEntityManager();
			InitialContext context = new InitialContext();
			context.bind("entityManager", entityManager);
		} catch (NamingException e) {
			logger.error("Error getting naming service", e);
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		try {
			logger.info(this.getClass().getName() + ">>> Shutting application and entity manager down." );
			InitialContext context = new InitialContext();
			EntityManager entityManager = (EntityManager) context.lookup("entityManager");
			entityManager.close();
		} catch (NamingException e) {
			logger.error("Error getting naming service", e);
		}
	}
}
