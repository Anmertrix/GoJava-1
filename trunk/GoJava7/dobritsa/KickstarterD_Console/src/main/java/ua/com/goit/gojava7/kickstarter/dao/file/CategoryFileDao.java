package ua.com.goit.gojava7.kickstarter.dao.file;

import java.util.List;

import ua.com.goit.gojava7.kickstarter.dao.CategoryDao;
import ua.com.goit.gojava7.kickstarter.dao.FileDao;
import ua.com.goit.gojava7.kickstarter.domain.Category;

public class CategoryFileDao extends FileDao<Category> implements CategoryDao {

	public CategoryFileDao(List<Category> data) {
		super(data);
	}
}