package ua.com.goit.gojava7.kickstarter.dao;

import java.util.List;

import ua.com.goit.gojava7.kickstarter.beans.Category;

public interface CategoryDao {

	public void add(Category category);

	public void remove(Category category);

	public List<Category> getAll();

	public Category getCategoryById(int id);
}