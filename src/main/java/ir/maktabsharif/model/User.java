package ir.maktabsharif.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "school_user")
public class User extends BaseModel{
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "national_code")
    private String nationalCode;
    @Temporal(TemporalType.DATE)
    private Date dob;
    @Embedded
    private Address address;
    @Enumerated(EnumType.STRING)
    private Gender gender;
}
