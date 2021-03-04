package ua.mandybur.university.handler;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import ua.mandybur.university.service.DepartmentService;

@Component
@AllArgsConstructor
public class GetCountOfEmployeeCommand implements Command {
    private final DepartmentService departmentService;

    @Override
    public void execute(String department) {
        System.out.println(departmentService.getCountOfEmployeeForDepartment(department));
    }
}
