package ua.com.goit.gojava7.kickstarter.view.page;

import ua.com.goit.gojava7.kickstarter.view.exception.ExitException;

public class ExitPage implements Page {

    @Override
    public void show() throws ExitException {
        System.out.println("I'm quitting. Bye!");

        throw new ExitException();
    }

    @Override
    public void remindToChoose() {
    }

    @Override
    public Page getUpdated(String command) {
        return null;
    }
}
