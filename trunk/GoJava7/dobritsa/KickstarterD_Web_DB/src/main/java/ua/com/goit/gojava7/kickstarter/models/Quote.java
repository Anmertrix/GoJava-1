package ua.com.goit.gojava7.kickstarter.models;

public class Quote {

	private String text;
	private String author;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return text + "- Author: " + author;
	}

	public boolean isEmpty() {
		return text == null;
	}

}
