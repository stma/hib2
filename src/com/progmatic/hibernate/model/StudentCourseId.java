package com.progmatic.hibernate.model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class StudentCourseId implements Serializable {
    private Long student_id;
    private Long course_id;

    // equals and hashCode methods
}
