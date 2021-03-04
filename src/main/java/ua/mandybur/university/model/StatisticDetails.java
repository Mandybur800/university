package ua.mandybur.university.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StatisticDetails {
    private Lecturer.Degree degree;
    private Long count;
}
