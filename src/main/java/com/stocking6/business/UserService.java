package com.stocking6.business;

import java.util.List;

import com.stocking6.domain.User;
import com.stocking6.persistence.DAOException;


public interface UserService {

	List<User> listAll() throws DAOException;
	void addUser(User user) throws DAOException;
	List<User> findUsersByName(String name) throws DAOException;
}
