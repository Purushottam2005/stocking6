package com.stocking6.managedbeans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import com.stocking6.business.CategoryService;
import com.stocking6.domain.Category;

@ManagedBean(name="categoryBean")
@RequestScoped
public class CategoryMB {
	
	private CategoryService categoryService;
	private Category category = new Category();
	private List<Category> selectedCategories = new ArrayList<>();
	
	public void save() {
		try{
			getCategoryService().addCategory(category);
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("Error", new FacesMessage("Could not add category."));
		}
	}
	
	public void search() {
		try{
			selectedCategories = getCategoryService().findCategoriesByName(category.getName());
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("Error", new FacesMessage("Could not search any category."));
		}
	}
	
	public void list() {
		try{
			selectedCategories = getCategoryService().listAll();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("Error", new FacesMessage("Could not list categories."));
		}
	}

	public List<Category> getSelectedCategories() {
		return selectedCategories;
	}

	public void setSelectedCategories(List<Category> selectedCategories) {
		this.selectedCategories = selectedCategories;
	}

	public CategoryService getCategoryService() {
		return categoryService;
	}

	@Inject
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
}
