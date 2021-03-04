package ua.mandybur.university.util;

import java.util.List;
import javax.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import ua.mandybur.university.model.Department;
import ua.mandybur.university.model.Lecturer;
import ua.mandybur.university.service.DepartmentService;
import ua.mandybur.university.service.LecturerService;

@Component
@AllArgsConstructor
public class DataInject {
    private final DepartmentService departmentService;
    private final LecturerService lecturerService;

    @PostConstruct
    public void init() {
        Lecturer fred = new Lecturer();
        fred.setDegree(Lecturer.Degree.ASSISTANT);
        fred.setFirstName("Fred");
        fred.setLastName("Hoster");
        fred.setSalary(15000);
        lecturerService.save(fred);
        Lecturer john = new Lecturer();
        john.setDegree(Lecturer.Degree.ASSOCIATE_PROFESSOR);
        john.setFirstName("John");
        john.setLastName("Travolta");
        john.setSalary(22000);
        lecturerService.save(john);
        Lecturer bread = new Lecturer();
        bread.setDegree(Lecturer.Degree.ASSOCIATE_PROFESSOR);
        bread.setFirstName("Bread");
        bread.setLastName("Denter");
        bread.setSalary(30000);
        lecturerService.save(bread);
        Lecturer sussen = new Lecturer();
        sussen.setDegree(Lecturer.Degree.PROFESSOR);
        sussen.setFirstName("Sussen");
        sussen.setLastName("Prytoka");
        sussen.setSalary(35000);
        lecturerService.save(sussen);
        Department uku = new Department();
        uku.setLecturers(List.of(fred,john, bread, sussen));
        uku.setHeadOfDepartment(sussen);
        uku.setName("UKU");
        departmentService.save(uku);
    }
}
