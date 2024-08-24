package com.workshop.student.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Course")
public class CourseEntity {
    @Id
    @GeneratedValue
    private Integer CourseId;
    private String CourseName;
    private String CourseDescription;

    @OneToMany(mappedBy = "course")
    private List<EnrollEntity> enrolls;
}
