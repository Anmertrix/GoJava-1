package com.tyomsky.kickstarter.dao;

import java.util.*;

import com.tyomsky.kickstarter.model.Category;
import com.tyomsky.kickstarter.model.Project;

public class MockDataRegistry implements DataRegistry {
    private List<Category> categories = new ArrayList<>();

    public MockDataRegistry() {
        Random random = new Random();
        for (int i = 0; i < 5 + random.nextInt(5); i++) {
            Category category = new Category("Category " + i);
            categories.add(category);
            List<Project> projects = new ArrayList<>();
            for (int j = 0; j < 5 + random.nextInt(9); j++) {
                Project project = new Project("project " + j,
                        "description of project" + j, random.nextInt(3000),
                        random.nextInt(2500), random.nextInt(100),
                        "history of project" + j, "www.youtube.com/?video=" + j + random.nextInt() + "/",
                        null);
                projects.add(project);
            }
            category.setProjects(projects);
        }
    }

    @Override
    public List<Category> getCategoriesList() {
        return categories;
    }

    @Override
    public String getSomeQuote() {
        return "WOW! SSUCH QUOTE!";
    }

    @Override
    public Category getCategoryById(int categoryId) {
        int categoryIndex = getIndexByID(categoryId);
        if (categoryIndex < categories.size()) {
            return categories.get(categoryIndex);
        } else {
            throw new IllegalArgumentException("category with this id doesn't exists");
        }
    }

    @Override
    public Project getProjectById(int categoryId, int projectId) {
        int categoryIndex = getIndexByID(categoryId);
        int projectIndex = getIndexByID(projectId);
        if (categoryIndex < categories.size() && projectIndex < categories.get(categoryIndex).getProjects().size()) {
            return categories.get(categoryIndex).getProjects().get(projectIndex);
        } else {
            throw new IllegalArgumentException("project with this id doesn't exists");
        }
    }

    private int getIndexByID(int id) {
        //some magic
        return id - 1;
    }

}