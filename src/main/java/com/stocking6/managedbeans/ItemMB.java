package com.stocking6.managedbeans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.stocking6.domain.Category;
import com.stocking6.domain.Item;
import com.stocking6.domain.dao.ItemDAO;
import com.stocking6.domain.dao.ItemJPADAO;
import com.stocking6.persistence.DAOException;

@ManagedBean(name="itemBean")
@RequestScoped
public class ItemMB {
	private Item item;
	private List<Item> selectedItems = new ArrayList<>();
	private ItemDAO itemDAO;

	public ItemMB(){
		item = new Item();
		item.setCategory(new Category());
	}
	
	public void save() {
		itemDAO = new ItemJPADAO();
		try {
			itemDAO.save(this.item);
		} catch (DAOException e) {
			FacesContext.getCurrentInstance().addMessage("Pau!", new FacesMessage("pau!!"));
		}
	}
	
	
	public void search() {
		itemDAO = new ItemJPADAO();
		try {
			selectedItems = itemDAO.getByName(item.getName());
		} catch (DAOException e) {
			FacesContext.getCurrentInstance().addMessage("Pau!", new FacesMessage("pau!!"));
		}
	}
	
	public void list() {
		itemDAO = new ItemJPADAO();
		try {
			itemDAO.getAll();
		} catch (DAOException e) {
			FacesContext.getCurrentInstance().addMessage("Pau!", new FacesMessage("pau!!"));
		}
	}


	public Item getItem() {
		return item;
	}


	public void setItem(Item item) {
		this.item = item;
	}


	public List<Item> getSelectedItems() {
		return selectedItems;
	}


	public void setSelectedItems(List<Item> selectedItems) {
		this.selectedItems = selectedItems;
	}

}
