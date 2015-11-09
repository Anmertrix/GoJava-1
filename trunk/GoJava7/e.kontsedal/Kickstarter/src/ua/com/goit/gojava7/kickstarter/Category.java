package ua.com.goit.gojava7.kickstarter;

import java.util.ArrayList;
import java.util.List;

public class Category {
	private int categoryId = 1;
	private String categoryName;
	private List<Project> projects = new ArrayList<>();

	public Category(String name) {
		this.categoryName = name;
		categoryId++;
	}

	public List<Project> getAllProjectsInCategory() {
		return projects;
	}

	public String getName() {
		return this.categoryName;
	}

	public int getCategoryId() {
		return this.categoryId;
	}

	public void setProject(Project project) {
		projects.add(project);
	}

	public Project getProject(int num) {
		return projects.get(num - 1);
	}
}
