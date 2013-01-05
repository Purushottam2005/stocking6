package com.stocking6.managedbeans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import com.stocking6.business.ItemService;
import com.stocking6.domain.Item;

@ManagedBean(name="itemBean")
@RequestScoped
public class ItemMB {
	
	@Inject 
	private ItemService itemService;
	private Item item = new Item();
	private List<Item> selectedItems = new ArrayList<>();

	public void save() {
		try{
			itemService.addItem(item);
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("Error", new FacesMessage("Could not add item."));
		}
	}
	
	public void search() {
		try{
			selectedItems = itemService.findItemsByName(item.getName());
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("Error", new FacesMessage("Could not search any item."));
		}
	}
	
	public void list() {
		try{
			selectedItems = itemService.listAll();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("Error", new FacesMessage("Could not list items."));
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
