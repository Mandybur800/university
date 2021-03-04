package ua.mandybur.university.service;

import java.util.List;
import ua.mandybur.university.model.Lecturer;

public interface LecturerService {
    Lecturer save(Lecturer lecturer);

    List<Lecturer> getByPattern(String pattern);
}
