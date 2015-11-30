package ua.com.goit.gojava7.kickstarter.dao.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import ua.com.goit.gojava7.kickstarter.dao.DbDao;
import ua.com.goit.gojava7.kickstarter.dao.storage.CategoryStorage;
import ua.com.goit.gojava7.kickstarter.domain.Category;

public class CategoryDbDao extends DbDao<Category> implements CategoryStorage {

	private static String TABLE = "category";
	private static String FIELDS = "name";

	public CategoryDbDao(Connection connection) {
		super(connection, FIELDS, TABLE);
	}

	@Override
	protected Category readElement(ResultSet resultSet) throws SQLException {
		Category category = new Category();
		category.setName(resultSet.getString("name"));
		return category;
	}
	
	 @Override
	    public void add(Category element) {
	        String query = "insert into category (name) values (?)";
	        try (PreparedStatement ps = connection.prepareStatement(query)) {
	        	ps.setString(2, element.getName());
	        	ps.executeUpdate();  
	            connection.commit();
	        } catch (SQLException e) {
	        	e.printStackTrace();
	        }
	    }
}
