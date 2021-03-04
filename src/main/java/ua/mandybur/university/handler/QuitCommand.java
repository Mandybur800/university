package ua.mandybur.university.handler;

import org.springframework.stereotype.Component;

@Component
public class QuitCommand implements Command {
    @Override
    public void execute(String input) {
        System.out.println("Program was finished");
        System.exit(0);
    }
}
