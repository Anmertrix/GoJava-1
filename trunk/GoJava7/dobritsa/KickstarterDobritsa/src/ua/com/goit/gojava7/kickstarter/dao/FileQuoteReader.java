package ua.com.goit.gojava7.kickstarter.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.domain.Quote;

public class FileQuoteReader implements QuoteReader {

	private File quotesFile;

	public FileQuoteReader(File quotesFile) {
		this.quotesFile = quotesFile;
	}

	@Override
	public List<Quote> readQuotes() {
		List<Quote> quotes = new ArrayList<>();

		BufferedReader fileReader = null;
		try {
			InputStream quotesFileSteam = new FileInputStream(quotesFile);
			fileReader = new BufferedReader(new InputStreamReader(quotesFileSteam));

			String line;
			while ((line = fileReader.readLine()) != null) {
				Quote quote = new Quote();
				quote.setText(line);
				quote.setAuthor(fileReader.readLine());
				quotes.add(quote);
			}

		} catch (IOException e) {
			throw new IllegalStateException("File not found or read error", e);
		} finally {
			if (fileReader != null) {
				try {
					fileReader.close();
				} catch (IOException e) {
					System.err.println("Cannot close file " + quotesFile);
				}
			}
		}

		if (quotes.isEmpty()) {
			throw new IllegalStateException("There is not quotes in file");
		}

		return quotes;
	}
}
