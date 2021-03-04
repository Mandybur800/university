package ua.mandybur.university.service.impl;

import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.mandybur.university.model.Department;
import ua.mandybur.university.model.StatisticDetails;
import ua.mandybur.university.repository.DepartmentRepository;
import ua.mandybur.university.service.DepartmentService;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;

    @Override
    public Department save(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Optional<Department> getHeadOfDepartment(String department) {
        return departmentRepository.findByName(department);
    }

    @Override
    public List<StatisticDetails> getStatistic(String department) {
        return departmentRepository.countByDegree(department);
    }

    @Override
    public double getAvgSalaryByDepartment(String department) {
        return departmentRepository.getAverageSalaryByDepartment(department);
    }

    @Override
    public int getCountOfEmployeeForDepartment(String department) {
        return departmentRepository.countAllLecturersByNameOfDepartment(department);
    }
}
