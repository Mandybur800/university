package ua.mandybur.university.handler;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import ua.mandybur.university.model.StatisticDetails;
import ua.mandybur.university.service.DepartmentService;

@Component
@AllArgsConstructor
public class ShowStatisticCommand implements Command {
    private final DepartmentService departmentService;

    @Override
    public void execute(String department) {
        List<StatisticDetails> statistics = departmentService.getStatistic(department);
        for (StatisticDetails details : statistics) {
            System.out.println(details.getDegree().name().toLowerCase()
                    + " - " + details.getCount());
        }
    }
}
