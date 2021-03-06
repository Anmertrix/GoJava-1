package ua.com.goit.gojava7.kickstarter;

import ua.com.goit.gojava7.kickstarter.controller.Controller;
import ua.com.goit.gojava7.kickstarter.model.Kickstarter;
import ua.com.goit.gojava7.kickstarter.model.storage.*;
import ua.com.goit.gojava7.kickstarter.view.ConsoleView;
import ua.com.goit.gojava7.kickstarter.view.View;

public class Launcher {
    public static void main(String[] args) {
        QuoteStorage quoteStorage;
        CategoryStorage categoryStorage;
        if (args != null && args.length > 0 && args[0].equals("f")) {
            quoteStorage = new FileQuoteStorage(Launcher.class.getResource("/quotes.txt").getPath());
            categoryStorage = new FileCategoryStorage(Launcher.class.getResource("/categories.txt").getPath(),
                    Launcher.class.getResource("/projects.txt").getPath());
        } else if (args != null && args.length > 0 && args[0].equals("d")) {
            quoteStorage = new DatabaseQuoteStorage("quotes");
            categoryStorage = new DatabaseCategoryStorage("categories", "projects");
        } else {
            quoteStorage = new InMemoryQuoteStorage();
            categoryStorage = new InMemoryCategoryStorage();
        }
        Kickstarter kickstarter = new Kickstarter(categoryStorage, quoteStorage);
        Controller controller = new Controller(kickstarter);
        View view = new ConsoleView(controller);
        view.run();
    }
}
