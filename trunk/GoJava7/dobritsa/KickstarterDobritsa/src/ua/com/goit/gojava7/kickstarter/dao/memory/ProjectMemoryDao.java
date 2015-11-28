package ua.com.goit.gojava7.kickstarter.dao.memory;

import java.util.List;
import java.util.stream.Collectors;

import ua.com.goit.gojava7.kickstarter.dao.MemoryDao;
import ua.com.goit.gojava7.kickstarter.dao.storage.ProjectStorage;
import ua.com.goit.gojava7.kickstarter.domain.Project;

public class ProjectMemoryDao extends MemoryDao<Project> implements ProjectStorage {

	public ProjectMemoryDao(List<Project> data) {
		super(data);
	}

	@Override
	public Project getByNumber(int number) {
		int index = number - 1;
		return get(index);
	}

	@Override
	public void updatePledged(Project project, int amount) {
		project.updatePledged(amount);
	}

	@Override
	public int getPledged(String projectName) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Project> getByCategory(String categoryName) {
		return this.getAll().stream().filter(project -> project.getCategoryName().equals(categoryName))
				.collect(Collectors.toList());
	}

}
