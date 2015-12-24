package ua.com.goit.gojava7.kickstarter.dao;

import ua.com.goit.gojava7.kickstarter.models.Category;

public interface CategoryDao extends Dao<Category> {

	public Category getByNumber(int number);

}