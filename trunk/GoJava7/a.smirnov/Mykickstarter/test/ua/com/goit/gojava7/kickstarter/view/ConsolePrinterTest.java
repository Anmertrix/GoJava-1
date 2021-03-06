package ua.com.goit.gojava7.kickstarter.view;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.verify;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import ua.com.goit.gojava7.kickstarter.beans.*;
import ua.com.goit.gojava7.kickstarter.dao.memory.CategoryDaoMemoryImpl;
import ua.com.goit.gojava7.kickstarter.dao.memory.FaqDaoMemoryImpl;
import ua.com.goit.gojava7.kickstarter.dao.memory.PaymentDaoMemoryImpl;

@RunWith(MockitoJUnitRunner.class)
public class ConsolePrinterTest {

	private ConsolePrinter consolePrinter = new ConsolePrinter();
		
	@Mock
	private PrintStream printSteam;

	
	@Before
	public void setUp() throws Exception {
		System.setOut(printSteam);
	}
	
	@Test
	public void testPrintQuote() {
		String quoteText = "Hello world!";
		String author = "Anton Smirnov";
		
		Quote quote = new Quote();
		quote.setQuoteText(quoteText);
		quote.setAuthor(author);
		
		consolePrinter.print(quote);
		verify(printSteam).println(contains(quoteText));
		verify(printSteam).println(contains(author));
		verify(printSteam).println(contains("(c)"));
	}

	@Test
	public void testPrintCategory() {
		String categoryName = "Stars";
		
		Category category = new Category();
		category.setName(categoryName);
		
		consolePrinter.print(category);
		verify(printSteam).println(contains(categoryName));	
	}

	@Test
	public void testPrintString() {
		String line = "Some text...";
		consolePrinter.print(line);
		verify(printSteam).println(line);
	}

	@Test
	public void testPrintShortProjectInfo() {				
		Project project = new Project();
		PaymentDaoMemoryImpl paymentStorage = new PaymentDaoMemoryImpl();		
		FaqDaoMemoryImpl faqStorage = new FaqDaoMemoryImpl();
		
		consolePrinter.printShortProjectInfo(project, faqStorage, paymentStorage);
		verify(printSteam).println(contains("Title : "));
		verify(printSteam).println(contains("Short description : "));
		verify(printSteam).println(contains("Required amount : "));
		verify(printSteam).println(contains("Gathered amount : "));
		verify(printSteam).println(contains("Days left : "));
		verify(printSteam).println(contains("FAQ : "));
	}

	@Test
	public void testPrintFullProjectInfo() {
		Project project = new Project();		
		PaymentDaoMemoryImpl paymentStorage = new PaymentDaoMemoryImpl();		
		FaqDaoMemoryImpl faqStorage = new FaqDaoMemoryImpl();
		
		consolePrinter.printShortProjectInfo(project, faqStorage, paymentStorage);
		verify(printSteam).println(contains("Title : "));
		verify(printSteam).println(contains("Short description : "));
		verify(printSteam).println(contains("Required amount : "));
		verify(printSteam).println(contains("Gathered amount : "));
		verify(printSteam).println(contains("Days left : "));
	}

	@Test
	public void testPrintCategories() {
		Category category1 = new Category();
		Category category2 = new Category();
		CategoryDaoMemoryImpl categoriesStorage = new CategoryDaoMemoryImpl();
		
		categoriesStorage.add(category1);
		categoriesStorage.add(category2);
		
		consolePrinter.printCategories(categoriesStorage);
		verify(printSteam).println(contains("All categories : "));
		verify(printSteam).println(contains(String.valueOf(String.valueOf(1))));
		verify(printSteam).println(contains(String.valueOf(String.valueOf(2))));
	}

	@Test
	public void testPrintProjects() {		
		Project project = new Project();
		PaymentDaoMemoryImpl paymentStorage = new PaymentDaoMemoryImpl();
		FaqDaoMemoryImpl faqStorage = new FaqDaoMemoryImpl();
		
		List<Project> projects = new ArrayList<>();
		projects.add(project);
		
		consolePrinter.printProjects(projects, faqStorage, paymentStorage);	
		verify(printSteam).println(contains("Title : "));
		verify(printSteam).println(contains("Short description : "));
		verify(printSteam).println(contains("Required amount : "));
		verify(printSteam).println(contains("Gathered amount : "));
		verify(printSteam).println(contains("Days left : "));
		verify(printSteam).println(contains("FAQ : "));
	}
}
