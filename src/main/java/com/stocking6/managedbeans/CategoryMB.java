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
	
	@Inject
	private CategoryService categoryService;
	private Category category = new Category();
	private List<Category> selectedCategories = new ArrayList<>();
	
	public void save() {
		try{
			categoryService.addCategory(category);
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("Error", new FacesMessage("Could not add category."));
		}
	}
	
	public void search() {
		try{
			selectedCategories = categoryService.findCategoriesByName(category.getName());
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("Error", new FacesMessage("Could not search any category."));
		}
	}
	
	public void list() {
		try{
			selectedCategories = categoryService.listAll();
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
}
