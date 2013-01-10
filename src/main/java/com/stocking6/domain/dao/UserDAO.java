package com.stocking6.domain.dao;

import java.util.List;

import com.stocking6.domain.User;
import com.stocking6.persistence.DAOException;

public interface UserDAO {
	User getByPrimaryKey (Long id) throws DAOException;
	void store (User entity) throws DAOException;
	void delete(User entity) throws DAOException;
	List<User> getAll() throws DAOException;
	List<User> getByName(String name) throws DAOException;
}
