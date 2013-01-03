package com.stocking6.domain.dao;

import java.util.HashMap;
import java.util.List;

import com.stocking6.domain.User;
import com.stocking6.persistence.DAOException;
import com.stocking6.persistence.GenericJPADAO;
import com.stocking6.persistence.PersistenceHelper;

public class UserJPADAO extends GenericJPADAO<Long, User> implements UserDAO {

	@Override
	public List<User> getByName(String name) throws DAOException {
		String jpql = "from User u where lower(u.name) like :name";
		HashMap<String, Object> params = new HashMap<>();
		params.put("name",  name);
		return (List<User>) PersistenceHelper.executeQuery(jpql, params);
	}
}
