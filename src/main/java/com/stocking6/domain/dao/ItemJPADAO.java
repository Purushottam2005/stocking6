package com.stocking6.domain.dao;

import java.util.HashMap;
import java.util.List;

import com.stocking6.domain.Category;
import com.stocking6.domain.Item;
import com.stocking6.persistence.DAOException;
import com.stocking6.persistence.GenericJPADAO;
import com.stocking6.persistence.PersistenceHelper;

public class ItemJPADAO extends GenericJPADAO<Long, Item> implements ItemDAO {

	@Override
	public List<Item> getByName(String name) throws DAOException {
		String jpql = "from Item u where lower(u.name) like :name";
		HashMap<String, String> params = new HashMap<>();
		params.put("name",  "%"+name+"%");
		return (List<Item>) PersistenceHelper.executeQuery(jpql, params);
	}

	
	@Override
	public List<Item> getByCategory(Category category) throws DAOException {
		String jpql = "from Item u where category = :category";
		HashMap<String, Object> params = new HashMap<>();
		params.put("category",  category);
		return (List<Item>) PersistenceHelper.executeQuery(jpql, params);
	}

}
