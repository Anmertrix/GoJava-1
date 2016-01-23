package com.kickstarter.dao.Interfaces;

import com.kickstarter.model.Project;

public interface PaymentDao {

	public Integer getAll(int projectId);

	public void addPayment(Project project, int amount);
}