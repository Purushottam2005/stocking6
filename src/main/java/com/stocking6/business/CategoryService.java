package com.stocking6.business;

import java.util.List;

import com.stocking6.domain.Category;
import com.stocking6.persistence.DAOException;


public interface CategoryService {

	List<Category> listAll() throws DAOException;
	void addCategory(Category category) throws DAOException;
	List<Category> findCategoriesByName(String name) throws DAOException;
}
