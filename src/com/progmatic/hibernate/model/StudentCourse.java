package com.progmatic.hibernate.model;

import jakarta.persistence.*;

@Entity
@Table(name = "student_course")
public class StudentCourse {
    @EmbeddedId
    private StudentCourseId id;
    // other properties and methods
    @ManyToOne
    @MapsId("student_id")
    private Student student;
    @ManyToOne
    @MapsId("course_id")
    private Course course;
    // getters and setters
}
