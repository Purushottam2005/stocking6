package com.stocking6.persistence;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PersistenceHelper {

	private static Logger logger = LoggerFactory
			.getLogger(PersistenceHelper.class);
	
	private static EntityManager em;
	
	static{
		try {
			InitialContext ctx = new InitialContext();
			em = (EntityManager) ctx.lookup("entityManager");
		} catch (NamingException e) {
			logger.error("[" + PersistenceHelper.class.getName()
					+ "] => Naming service exception", e);
		}
	}
	
	public static List executeQuery(String sql) throws DAOException {
		return executeQuery(sql, null);
	}
	
	public static List executeQuery(String sql, Map params) throws DAOException {
		try {
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			Query query = em.createQuery(sql);

			if (params != null && params.size() > 0) {
				Iterator itParameterNames = params.keySet().iterator();
				while (itParameterNames.hasNext()) {
					String paramName = (String) itParameterNames.next();
					Object value = params.get(paramName);
					query.setParameter(paramName, value);
				}
			}
			List results = query.getResultList();
			tx.commit();
			return results;
		} catch (Exception e) {
			logger.error("[" + PersistenceHelper.class.getName()
					+ "] => Query error", e);
			throw new DAOException();
		}
	}

	public static void save(Object obj) throws DAOException {
		try {
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			em.persist(obj);
			tx.commit();
		} catch (Exception e) {
			logger.error("[" + PersistenceHelper.class.getName()
					+ "] => Query error", e);
			throw new DAOException();
		} 
	}

	public static Object getById(Class klass, Serializable id)
			throws DAOException {
		try {
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			Object obj = em.find(klass, id);
			tx.commit();
			return obj;
		} catch (Exception e) {
			logger.error("[" + PersistenceHelper.class.getName()
					+ "] => Query error", e);
			throw new DAOException();
		}
	}

	public static void delete(Object obj) throws DAOException {
		try {
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			em.remove(obj);
			tx.commit();
		} catch (Exception e) {
			logger.error("[" + PersistenceHelper.class.getName()
					+ "] => Query error", e);
			throw new DAOException();
		} 
	}
}
