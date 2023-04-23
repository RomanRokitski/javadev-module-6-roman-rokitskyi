package org.example.requestClasses;

import lombok.Builder;
import lombok.ToString;

import java.time.LocalDate;

@Builder
@ToString

public class FindLongestProject {
    private String name;
    private LocalDate start_date;
    private LocalDate finish_date;
    private int month_count;
}
