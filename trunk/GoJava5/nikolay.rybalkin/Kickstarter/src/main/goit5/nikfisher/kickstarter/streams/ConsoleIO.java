package goit5.nikfisher.kickstarter.streams;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class ConsoleIO implements ConsoleInterfaceIO {

    final static Logger LOGGER = LoggerFactory.getLogger(ConsoleIO.class);

    private Scanner scanner = new Scanner(System.in);

    @Override
    public String consoleScanString() {
        return scanner.next();
    }

    @Override
    public int consoleScanInt() {
        int number = 0;
        try {
            scanner.hasNextInt();
            number = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("You entered is not a number!");
            LOGGER.error("You entered is not a number!");
        }
        return number;
    }

    @Override
    public void println(String result) {
        System.out.println(result);
    }

    @Override
    public void print(String result) {
        System.out.println(result);
    }
}
