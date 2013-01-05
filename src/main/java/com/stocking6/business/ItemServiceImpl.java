package com.stocking6.business;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.stocking6.domain.Item;
import com.stocking6.domain.dao.ItemDAO;
import com.stocking6.domain.dao.ItemJPADAO;

@Named
@RequestScoped
public class ItemServiceImpl implements ItemService {

	@Inject
	private ItemDAO itemDAO;
	
	@Override
	public void addItem(Item item) {
		itemDAO = new ItemJPADAO();
		itemDAO.save(item);
	}

	@Override
	public List<Item> findItemsByName(String name){
		return itemDAO.getByName(name);
	}

	@Override
	public List<Item> listAll() {
		return itemDAO.getAll();
	}
}