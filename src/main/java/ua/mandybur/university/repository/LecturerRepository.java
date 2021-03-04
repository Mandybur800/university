package ua.mandybur.university.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ua.mandybur.university.model.Lecturer;

public interface LecturerRepository extends JpaRepository<Lecturer, Long> {
    @Query(value = "FROM lecturers l WHERE l.firstName LIKE CONCAT('%', CONCAT(?1,'%'))"
            + " OR l.lastName LIKE CONCAT('%', CONCAT(?1,'%'))")
    List<Lecturer> getAllByFirstNameLikeOrLastNameLike(String patter);
}
