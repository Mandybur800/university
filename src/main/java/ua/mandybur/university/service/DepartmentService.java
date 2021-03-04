package ua.mandybur.university.service;

import java.util.List;
import java.util.Optional;
import ua.mandybur.university.model.Department;
import ua.mandybur.university.model.StatisticDetails;

public interface DepartmentService {
    Department save(Department department);

    Optional<Department> getHeadOfDepartment(String department);

    List<StatisticDetails> getStatistic(String department);

    double getAvgSalaryByDepartment(String department);

    int getCountOfEmployeeForDepartment(String department);
}
