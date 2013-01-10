package com.stocking6.persistence;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class GenericJPADAO<ID extends Serializable, ENT> {
	private Class<ENT> entityClass = null;
	
	private Class<ENT> getEntityClass(){
		if (entityClass == null){
			ParameterizedType paramType = (ParameterizedType) getClass().getGenericSuperclass();
			entityClass = (Class<ENT>) paramType.getActualTypeArguments()[0];
		}
		return entityClass;
	}
	
	public ENT getByPrimaryKey (ID id) throws DAOException{
		return (ENT) PersistenceHelper.getById(getEntityClass(), id);
	}

	public List<ENT> getAll () throws DAOException{
		String jpql = "from " + getEntityClass().getName().toLowerCase();
		return (List<ENT>) PersistenceHelper.executeQuery(jpql);
	}
	
	public void store (ENT entity) throws DAOException{
		PersistenceHelper.store(entity);
	}
	
	public void delete(ENT entity) throws DAOException{
		PersistenceHelper.delete(entity);
	}
}
