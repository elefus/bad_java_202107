package com.bad_java.lectures._12.data;

import lombok.Value;

import java.util.List;

@Value
public class Employee {

    Person person;
    List<JobHistoryEntry> jobHistory;
}
