package ir.maktabsharif.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@NamedQuery(name = "Student.findByFirstName", query = "FROM Student WHERE firstName = ?1")
@Table(name = "student")
public class Student extends User {


    //many to many association uni directional
    @ManyToMany
    @JoinTable(name = "j_student_course",
            joinColumns = {@JoinColumn(name = "fk_student")},
            inverseJoinColumns = {@JoinColumn(name = "fk_course")}
    )
    private List<Course> courses = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "j_student_exam",
            joinColumns = {@JoinColumn(name = "fk_student")}
            , inverseJoinColumns = {@JoinColumn(name = "fk_exam")}
    )

    private List<Exam> exams = new ArrayList<>();

}

