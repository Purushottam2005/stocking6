package com.stocking6.domain.dao;

import java.util.List;

import com.stocking6.domain.Category;
import com.stocking6.domain.Item;
import com.stocking6.persistence.DAOException;

public interface ItemDAO {
	Item getByPrimaryKey (Long id) throws DAOException;
	void store (Item entity) throws DAOException;
	void delete(Item entity) throws DAOException;
	List<Item> getAll() throws DAOException;
	List<Item> getByName(String name) throws DAOException;
	List<Item> getByCategory(Category category) throws DAOException;
}
