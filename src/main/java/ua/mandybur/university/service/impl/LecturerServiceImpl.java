package ua.mandybur.university.service.impl;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.mandybur.university.model.Lecturer;
import ua.mandybur.university.repository.LecturerRepository;
import ua.mandybur.university.service.LecturerService;

@Service
@AllArgsConstructor
public class LecturerServiceImpl implements LecturerService {
    private final LecturerRepository lecturerRepository;

    @Override
    public Lecturer save(Lecturer lecturer) {
        return lecturerRepository.save(lecturer);
    }

    @Override
    public List<Lecturer> getByPattern(String pattern) {
        return lecturerRepository.getAllByFirstNameLikeOrLastNameLike(pattern);
    }
}
