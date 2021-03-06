package com.sergiisavin.kickstarter;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import com.sergiisavin.kickstarter.userinterface.dispatcher.PageDispatcher;
import com.sergiisavin.kickstarter.userinterface.pages.CategoriesPage;
import com.sergiisavin.kickstarter.userinterface.pages.MainMenuPage;
import com.sergiisavin.kickstarter.userinterface.printer.Printer;
import com.sergiisavin.kickstarter.userinterface.printer.UpperCaseConsolePrinter;


public class MainMenuTest {

	@Test
	public void test() {
		//Kickstarter kickstarterMock = mock(Kickstarter.class);
		//when(kickstarterMock.getCategories()).thenReturn(new String[] {"Toys", "Gadgets"});
		//PageDispatcher dispatcherMock = mock(PageDispatcher.class);
		Printer printer = new UpperCaseConsolePrinter();
		MainMenuPage page = new MainMenuPage(printer);
		assertNotNull(page);
		//page.injectKickcstarter(kickstarterMock);
		//page.injectPageDispatcher(dispatcherMock);
		
		page.constructPage();
		//page.show();
	}

}
