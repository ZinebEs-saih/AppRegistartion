package com.helze.registration.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity @Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private Date date;



    private String duration;
    @ManyToMany(mappedBy = "courseset", fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Student> studentSet = new HashSet<>();





    public Course(String name, Date date, String duration) {
        this.name = name;
        this.date = date;
        this.duration = duration;
    }
    public Course(String name) {
        this.name = name;
    }
}

