package ua.com.goit.gojava7.kickstarter.models;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import ua.com.goit.gojava7.kickstarter.models.Quote;
import static org.mockito.Matchers.contains;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import java.io.PrintStream;

@RunWith(MockitoJUnitRunner.class)
public class QuoteTest extends Assert {

	@Mock
	private PrintStream printSteam;

	private Quote quote = new Quote();

	@Before
	public void setUp() {
		quote.setQuoteId(10L);
		quote.setText("TestQuote");
		quote.setAuthor("TestAuthor");
		System.setOut(printSteam);
	}

	@After
	public void tearDown() {
		verifyNoMoreInteractions(printSteam);
	}

	@Test
	public void testGet() {
		assertThat(quote.getQuoteId(), is(10L));
		assertThat(quote.getText(), is("TestQuote"));
		assertThat(quote.getAuthor(), is("TestAuthor"));
	}

	@Test
	public void testToString() {
		System.out.println(quote.toString());
		verify(printSteam).println(contains("TestQuote"));
		verify(printSteam).println(contains("TestAuthor"));
	}

	@Test
	public void testIsNotEmpty() {
		assertFalse(quote.isEmpty());
	}

	@Test
	public void testIsEmpty() {
		Quote quoteEmpty = new Quote();
		assertTrue(quoteEmpty.isEmpty());
	}
}
