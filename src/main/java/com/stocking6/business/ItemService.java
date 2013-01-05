package com.stocking6.business;

import java.util.List;

import com.stocking6.domain.Item;
import com.stocking6.persistence.DAOException;

public interface ItemService {
	List<Item> listAll() throws DAOException;
	void addItem(Item item) throws DAOException;
	List<Item> findItemsByName(String name) throws DAOException;
}
