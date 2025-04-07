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
@Table(name = "exam")
public class Exam extends BaseModel{
    @Column(name = "exam_title")
    private String title;
    private Float score;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "exam_time")
    private Date examTime;

    @ManyToOne
    @JoinColumn(name = "fk_course")
    private Course course;

    @ManyToMany(mappedBy = "exams")
    private List<Student> students = new ArrayList<>();


}
