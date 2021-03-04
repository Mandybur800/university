package ua.mandybur.university.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ua.mandybur.university.model.Department;
import ua.mandybur.university.model.StatisticDetails;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Optional<Department> findByName(String name);

    @Query(value = "SELECT new ua.mandybur.university.model.StatisticDetails(l.degree, COUNT(l))"
            + " FROM departments d JOIN d.lecturers l WHERE d.name = ?1 GROUP BY d, l.degree")
    List<StatisticDetails> countByDegree(String department);

    @Query(value = "SELECT AVG(l.salary) FROM departments d JOIN d.lecturers l WHERE d.name = ?1")
    double getAverageSalaryByDepartment(String department);

    @Query(value = "SELECT COUNT(l) FROM departments d JOIN d.lecturers l WHERE d.name = ?1")
    int countAllLecturersByNameOfDepartment(String department);
}
