package ua.mandybur.university.handler;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import ua.mandybur.university.service.DepartmentService;

@Component
@AllArgsConstructor
public class GetAvgSalaryByDepartmentCommand implements Command {
    private final DepartmentService departmentService;

    @Override
    public void execute(String department) {
        System.out.printf("The average salary of %s is %.2f\n", department,
                departmentService.getAvgSalaryByDepartment(department));
    }
}
