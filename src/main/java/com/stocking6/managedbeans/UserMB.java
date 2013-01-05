package com.stocking6.managedbeans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import com.stocking6.business.UserService;
import com.stocking6.domain.User;

@ManagedBean(name="userBean")
@RequestScoped
public class UserMB {
	
	@Inject
	private UserService userService;
	private User user = new User();
	private List<User> selectedUsers = new ArrayList<>();
	
	public void save() {
		try{
			userService.addUser(user);
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("Error", new FacesMessage("Could not add user."));
		}
	}
	
	public void search() {
		try{
			selectedUsers = userService.findUsersByName(user.getName());
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("Error", new FacesMessage("Could not search any user."));
		}
	}
	
	public void list() {
		try{
			selectedUsers = userService.listAll();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("Error", new FacesMessage("Could not list users."));
		}
	}

	public List<User> getSelectedUsers() {
		return selectedUsers;
	}

	public void setSelectedUsers(List<User> selectedUsers) {
		this.selectedUsers = selectedUsers;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
