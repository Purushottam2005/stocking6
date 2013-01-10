package com.stocking6.domain.dao;

import java.util.List;

import com.stocking6.domain.Category;
import com.stocking6.persistence.DAOException;

public interface CategoryDAO {
	Category getByPrimaryKey (Long id) throws DAOException;
	void store (Category entity) throws DAOException;
	void delete(Category entity) throws DAOException;
	List<Category> getAll() throws DAOException;
	List<Category> getByName(String name) throws DAOException;
}
