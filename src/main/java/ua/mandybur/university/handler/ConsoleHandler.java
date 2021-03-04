package ua.mandybur.university.handler;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class ConsoleHandler {
    private final Map<String, Command> handler = new HashMap<>();

    public ConsoleHandler(ApplicationContext applicationContext) {
        handler.put("Who is head of department ([\\w ]+)",
                applicationContext.getBean(HeadOfDepartmentCommand.class));
        handler.put("(help)",applicationContext.getBean(HelpCommand.class));
        handler.put("(exit)|q|quit", applicationContext.getBean(QuitCommand.class));
        handler.put("Show ([\\w ]+) statistics",
                applicationContext.getBean(ShowStatisticCommand.class));
        handler.put("Show the average salary for the department ([\\w ]+)",
                applicationContext.getBean(GetAvgSalaryByDepartmentCommand.class));
        handler.put("Show count of employee for ([\\w ]+)",
                applicationContext.getBean(GetCountOfEmployeeCommand.class));
        handler.put("Global search by ([\\w ]+)",
                applicationContext.getBean(GetByPatternCommand.class));
    }

    public void handle() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type 'help' for more details");
        boolean isCorrect = false;
        while (true) {
            String input = scanner.nextLine();
            for (Map.Entry<String, Command> entry: handler.entrySet()) {
                if (input.matches(entry.getKey())) {
                    entry.getValue().execute(input.replaceAll(entry.getKey(), "$1"));
                    isCorrect = true;
                    break;
                }

            }
            if (!isCorrect) {
                System.out.println("Incorrect command! Please, try again.");
            }
            isCorrect = false;
        }
    }
}
