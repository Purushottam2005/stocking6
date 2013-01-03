package com.stocking6.domain.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.stocking6.domain.Category;
import com.stocking6.persistence.DAOException;
import com.stocking6.persistence.GenericJPADAO;
import com.stocking6.persistence.PersistenceHelper;

public class CategoryJPADAO extends GenericJPADAO<Long, Category> implements
		CategoryDAO {

	@Override
	public List<Category> getByName(String name)
			throws DAOException {
		String hql = "from Category c where lower(c.name) like :name ";
		Map<String, Object> params = new HashMap<>();
		params.put("name", "%"+name+"%");
		return PersistenceHelper.executeQuery(hql, params);
	}
}
