package com.progmatic.hibernate.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(mappedBy = "courses")
    private Set<Student> students;

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    private String name;

    private Integer minHeadCount;

    private Integer maxHeadCount;

    private String teacher;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMinHeadCount() {
        return minHeadCount;
    }

    public void setMinHeadCount(Integer minHeadCount) {
        this.minHeadCount = minHeadCount;
    }

    public Integer getMaxHeadCount() {
        return maxHeadCount;
    }

    public void setMaxHeadCount(Integer maxHeadCount) {
        this.maxHeadCount = maxHeadCount;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Course {" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", minHeadCount=" + minHeadCount +
                ", maxHeadCount=" + maxHeadCount +
                ", teacher='" + teacher + '\'' +
                '}';
    }
}
