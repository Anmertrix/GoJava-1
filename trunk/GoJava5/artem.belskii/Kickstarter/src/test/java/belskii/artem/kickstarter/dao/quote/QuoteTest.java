package belskii.artem.kickstarter.dao.quote;

import static org.junit.Assert.*;

import org.junit.Test;

public class QuoteTest {

	@Test
	public void testQuote() {
		Quote quote = new Quote(1, "Some Test");
		assertNotNull(quote);
	}

}
