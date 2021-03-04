package ua.mandybur.university.handler;

import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import ua.mandybur.university.model.Lecturer;
import ua.mandybur.university.service.LecturerService;

@Component
@AllArgsConstructor
public class GetByPatternCommand implements Command {
    private final LecturerService lecturerService;

    @Override
    public void execute(String pattern) {
        List<Lecturer> lecturers = lecturerService.getByPattern(pattern);
        String result = lecturers
                .stream()
                .map(l -> l.getFirstName() + " " + l.getLastName())
                .collect(Collectors.joining(", "));
        System.out.println(result);
    }
}
