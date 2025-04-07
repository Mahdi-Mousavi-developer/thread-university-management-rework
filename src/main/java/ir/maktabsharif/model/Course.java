package ir.maktabsharif.model;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Course extends BaseModel {

    @Column(name = "course_name")
    private String name;
    @Column(name = "course_unit")
    private Integer unit;

    @ManyToMany(mappedBy = "courses")
    private List<Student> students = new ArrayList<>();

    @OneToMany(mappedBy = "course")
    private List<Exam> exams = new ArrayList<>();



}
