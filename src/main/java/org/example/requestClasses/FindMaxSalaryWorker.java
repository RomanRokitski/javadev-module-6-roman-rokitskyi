package org.example.requestClasses;

import lombok.Builder;
import lombok.ToString;

@Builder
@ToString

public class FindMaxSalaryWorker {
    private String name;
    private int salary;
}
