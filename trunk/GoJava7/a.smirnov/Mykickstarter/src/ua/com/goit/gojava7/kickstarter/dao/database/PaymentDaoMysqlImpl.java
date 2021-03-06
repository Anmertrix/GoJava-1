package ua.com.goit.gojava7.kickstarter.dao.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.beans.Payment;
import ua.com.goit.gojava7.kickstarter.beans.Project;
import ua.com.goit.gojava7.kickstarter.dao.AbstractPaymentDao;

public class PaymentDaoMysqlImpl extends AbstractPaymentDao {
	private static final String INSERT_PAYMENT = "INSERT INTO payments (project_id, user_name, credit_card_number, donating_sum) VALUES (?, ?, ?, ?)";
	private static final String DELETE_PAYMENT = "DELETE FROM payments WHERE project_id = ?";
	private static final String SELECT_ALL_PAYMENTS = "SELECT project_id, user_name, credit_card_number, donating_sum  FROM payments";
	private static final String COUNT_ALL_PAYMENTS = "SELECT count(*) FROM payments";
	private static final String SELECT_PROJECT_PAYMENTS = "SELECT donating_sum FROM payments WHERE project_id = ?";

	@Override
	public void add(Payment payment) {
		try (Connection connection = DriverManager.getConnection(DATABASE_URL, USER_NAME, PASSWORD);
				PreparedStatement statement = connection.prepareStatement(INSERT_PAYMENT)) {

			statement.setInt(1, payment.getProjectID());
			statement.setString(2, payment.getUserName());
			statement.setLong(3, payment.getCreditCardNumber());
			statement.setInt(4, payment.getDonatingSum());
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void remove(Payment payment) {
		try (Connection connection = DriverManager.getConnection(DATABASE_URL, USER_NAME, PASSWORD);
				PreparedStatement statement = connection.prepareStatement(DELETE_PAYMENT)) {

			statement.setInt(1, payment.getProjectID());
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<Payment> getAll() {
		List<Payment> payments = new ArrayList<>();
		try (Connection connection = DriverManager.getConnection(DATABASE_URL, USER_NAME, PASSWORD);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(SELECT_ALL_PAYMENTS)) {
					
			while (resultSet.next()) {
				Payment payment = new Payment();
				payment.setProjectID(resultSet.getInt("project_id"));
				payment.setUserName(resultSet.getString("user_name"));
				payment.setCreditCardNumber(resultSet.getLong("creditCardNumber"));
				payment.setDonatingSum(resultSet.getInt("donating_sum"));

				payments.add(payment);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return payments;
	}

	@Override
	public int getSize() {
		int amountOfPayments = 0;
		try (Connection connection = DriverManager.getConnection(DATABASE_URL, USER_NAME, PASSWORD);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(COUNT_ALL_PAYMENTS)) {

			while (resultSet.next()) {
				amountOfPayments = resultSet.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return amountOfPayments;
	}

	@Override
	public int getSumProjectPayments(Project project) {
		int collectedSum = 0;
		try (Connection connection = DriverManager.getConnection(DATABASE_URL, USER_NAME, PASSWORD);
				PreparedStatement statement = connection.prepareStatement(SELECT_PROJECT_PAYMENTS)) {
			
			statement.setInt(1, project.getUniqueID());
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				int donatingSum = resultSet.getInt("donating_sum");
				collectedSum += donatingSum;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return collectedSum;
	}
}
