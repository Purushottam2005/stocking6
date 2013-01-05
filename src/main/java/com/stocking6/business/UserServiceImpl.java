package com.stocking6.business;

import java.util.List;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.stocking6.domain.User;
import com.stocking6.domain.dao.UserDAO;

@Named
@RequestScoped
public class UserServiceImpl implements UserService {

	@Inject
	private UserDAO userDAO;
	
	@Override
	public void addUser(User user) {
		userDAO.save(user);
	}

	@Override
	public List<User> findUsersByName(String name){
		return userDAO.getByName(name);
	}

	@Override
	public List<User> listAll() {
		return userDAO.getAll();
	}
}
