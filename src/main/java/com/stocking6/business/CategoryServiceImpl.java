package com.stocking6.business;

import java.util.List;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.stocking6.domain.Category;
import com.stocking6.domain.dao.CategoryDAO;
import com.stocking6.domain.dao.CategoryJPADAO;

@Named
@RequestScoped
public class CategoryServiceImpl implements CategoryService {

	@Inject
	private CategoryDAO categoryDAO;
	
	@Override
	public void addCategory(Category category) {
		categoryDAO = new CategoryJPADAO();
		categoryDAO.save(category);
	}

	@Override
	public List<Category> findCategoriesByName(String name){
		return categoryDAO.getByName(name);
	}

	@Override
	public List<Category> listAll() {
		return categoryDAO.getAll();
	}
}
