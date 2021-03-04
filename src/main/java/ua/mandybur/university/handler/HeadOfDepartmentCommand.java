package ua.mandybur.university.handler;

import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import ua.mandybur.university.model.Department;
import ua.mandybur.university.service.DepartmentService;

@Component
@AllArgsConstructor
public class HeadOfDepartmentCommand implements Command {
    private final DepartmentService departmentService;

    @Override
    public void execute(String inputDepartment) {
        Optional<Department> optionalDepartment
                = departmentService.getHeadOfDepartment(inputDepartment);
        if (optionalDepartment.isPresent()) {
            Department department = optionalDepartment.get();
            System.out.printf("Head of %s department is %s %s%n\n", inputDepartment,
                    department.getHeadOfDepartment().getFirstName(),
                    department.getHeadOfDepartment().getLastName());
            return;
        }
        System.out.println("Incorrect name of department");
    }

}
