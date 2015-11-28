package ua.com.goit.gojava7.kickstarter.dao.file;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.File;

import org.junit.Test;

import ua.com.goit.gojava7.kickstarter.exception.WrongFileFormatException;

public class CategoryDaoFileImplTest {
	private File testCategoriesFile;
	private CategoryDaoFileImpl �ategoryDaoFileImpl;

	@Test
	public void testGetCategories() {
		testCategoriesFile = new File("./resources/categories.csv");
		�ategoryDaoFileImpl = new CategoryDaoFileImpl(testCategoriesFile);
		assertThat(�ategoryDaoFileImpl.getCategories().size(), is(3));
	}

	@Test(expected = WrongFileFormatException.class)
	public void testGetcategoriesNotcategoriesInFile() {
		testCategoriesFile = new File("./resources/nocategories.csv");
		�ategoryDaoFileImpl = new CategoryDaoFileImpl(testCategoriesFile);
		�ategoryDaoFileImpl.getCategories();
	}

	@Test(expected = WrongFileFormatException.class)
	public void testGetcategoriesNocategoriesFile() {
		testCategoriesFile = new File("./resources/notExistentcategories.csv");
		�ategoryDaoFileImpl = new CategoryDaoFileImpl(testCategoriesFile);
		�ategoryDaoFileImpl.getCategories();
	}

	@Test
	public void testGetCategory() {
		testCategoriesFile = new File("./resources/categories.csv");
		�ategoryDaoFileImpl = new CategoryDaoFileImpl(testCategoriesFile);
		assertThat(�ategoryDaoFileImpl.getCategory(3).getName(), is("Categ3"));
	}

	@Test
	public void testSize() {
		testCategoriesFile = new File("./resources/categories.csv");
		�ategoryDaoFileImpl = new CategoryDaoFileImpl(testCategoriesFile);
		assertThat(�ategoryDaoFileImpl.size(), is(3));
	}
}
