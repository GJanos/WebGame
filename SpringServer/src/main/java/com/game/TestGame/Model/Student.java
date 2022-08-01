package com.game.TestGame.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class Student {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private Address address;

    public Student(String firstName, String lastName, Address address, List<String> favouriteSubject) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.favouriteSubject = favouriteSubject;
    }

    private List<String> favouriteSubject;
}
