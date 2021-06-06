package com.geektrust.family.model;

import lombok.Data;

import java.util.*;

@Data
public class Person {
    private String name;
    private String gender;
    private Person partner;
    private List<Person> children;
    private Parents parents;
}
