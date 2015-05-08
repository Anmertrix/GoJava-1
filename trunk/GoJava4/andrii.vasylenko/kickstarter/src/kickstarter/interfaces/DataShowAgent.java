package kickstarter.interfaces;

import kickstarter.data_types.Category;
import kickstarter.data_types.Data;
import kickstarter.data_types.Project;
import kickstarter.data_types.Quote;
import kickstarter.storages.Storage;

public class DataShowAgent {
	public String getDescription(Data data) {
		if (data instanceof Quote) {
			return getDescription((Quote) data);
		} else if (data instanceof Category) {
			return getDescription((Category) data);
		} else if (data instanceof Project) {
			return getDescription((Project) data);
		}
		throw new UnsupportedOperationException();
	}

	public String getDetailedDescription(Data data) {
		if (data instanceof Project) {
			return getDetailedDescription((Project) data);
		}
		throw new UnsupportedOperationException();
	}
	
	public String getItemsDescription(Storage<? extends Data> storage) {
		StringBuilder result = new StringBuilder();

		if (storage != null) {
			for (int i = 0; i < storage.size(); i++) {
				result.append(getDescription(storage.get(i)));
				result.append("\r\n");
			}
		}

		result.append(Data.Default.EXIT.getId() + " - exit");

		return result.toString();
	}

	public String getCategoryPageHead() {
		return "Choice Category:";
	}
	
	public String getProjectPageHead() {
		return "Choice Project:";
	}
	
	public String getTheEndPageHead() {
		return "Good Luck!";
	}
	
	public String getErrorMessage() {
		return "try again please";
	}
	
	private String getDescription(Category category) {
		return category.getId() + " - " + category.getName();
	}

	private String getDescription(Quote quote) {
		return "Quote: " + quote.getQuote();
	}

	private String getDescription(Project project) {
		StringBuilder result = new StringBuilder();

		result.append(project.getId());
		result.append(" - " + project.getName());
		result.append(", description=" + project.getDescription());
		result.append(", totalAmount=" + project.getTotalAmount());
		result.append(", collectAmount=" + project.getCollectAmount());
		result.append(", daysLeft=" + project.getDaysLeft());

		return result.toString();
	}

	private String getDetailedDescription(Project project) {
		StringBuilder result = new StringBuilder();

		result.append("name=");
		result.append(project.getName());
		result.append("\r\n description=");
		result.append(project.getDescription());
		result.append("\r\n totalAmount=");
		result.append(project.getTotalAmount());
		result.append("\r\n collectAmount=");
		result.append(project.getCollectAmount());
		result.append("\r\n daysLeft=");
		result.append(project.getDaysLeft());
		result.append("\r\n history=");
		result.append(project.getHistory());
		result.append("\r\n link=");
		result.append(project.getLink());
		result.append("\r\n questionsAndAnswers=");
		result.append(project.getQuestionsAndAnswers());

		return result.toString();
	}
}