package ua.com.goit.gojava7.kickstarter.view;

import java.util.List;
<<<<<<< HEAD

import ua.com.goit.gojava7.kickstarter.dao.CategoryDAO;
=======
// OLEG unused
import java.util.Scanner;

import ua.com.goit.gojava7.kickstarter.dao.CategoryDAO;
//OLEG unused
import ua.com.goit.gojava7.kickstarter.dao.ProjectDAO;
>>>>>>> ab663b305363e409959091aee5fef442b1a5cbf8
import ua.com.goit.gojava7.kickstarter.model.Category;

public class PrinterCategory {

	public void printAllCategories(CategoryDAO storageOfCategories) {
		List<Category> listOfAllCategories = storageOfCategories.getDataSource();
		int amountOfCategories = listOfAllCategories.size();
		StringBuilder result = new StringBuilder();
		
		for (int index = 0; index < amountOfCategories; index++) {
			result.append(index + 1).
				append(". ").
				append(listOfAllCategories.get(index).getName()).
				append("\n");
		}
		System.out.println(result.toString());
	}
	
	
}
