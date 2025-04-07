package ir.maktabsharif.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "teacher")
public class Teacher extends User {

    @OneToOne
    @JoinColumn(name = "fk_course")
    private Course course;
}
