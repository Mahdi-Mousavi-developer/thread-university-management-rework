package ir.maktabsharif;

import ir.maktabsharif.model.Student;
import ir.maktabsharif.repository.Impl.StudentRepository;
import ir.maktabsharif.thread.MainThread;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) throws SQLException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jdbc-postgres");
        EntityManager em = emf.createEntityManager();


         StudentRepository studentRepository = new StudentRepository(em);
         Student student = new Student();
         student.setFirstName("jack");
         student.setLastName("smith");
         studentRepository.persist(student);

        Long count = studentRepository.getStudentsCount();
        System.out.println(count);










        /*em.getTransaction().begin();
        Address address = Address.builder()
                .country("Iran")
                .city("Tehran")
                .street("Valiasr")
                .zipCode("1234567890")
                .build();
        Teacher teacher = Teacher.builder().firstName("john").lastName("smith").gender(Gender.MALE).address(address).build();
        em.persist(teacher);
        em.getTransaction().commit();
        em.close();*/


      /* Student student = Student.builder().firstName("milad").lastName("faraji").build();
        studentRepository.persist(student);
        Student student1 = Student.builder().firstName("james").lastName("hetfield").build();
        studentRepository.persist(student1);
        Student student2 = Student.builder().firstName("johnny").lastName("cash").build();
        studentRepository.persist(student2);
        Student student3 = Student.builder().firstName("gary").lastName("moore").build();
        studentRepository.persist(student3);*/



       /* Student updatedStudent = Student.builder().lastName("jafari").build();
        updatedStudent.setId(1L);
        studentRepository.update(updatedStudent);*/

/*
        Optional<Student> byId = studentRepository.findById(1L);
        if ((byId.isPresent())) {
            System.out.println("student found");
        } else
            System.out.println("student not found");*/


      /*  Thread thread = new Thread(new MainThread(studentRepository));
        thread.start();*/

    }
}




        /*Student student = new Student();
        student.setFirstName("Jack");
        student.setLastName("Smith");*/

//Student student = new Student(1L,"John","Doe");

//instead of upper initiation we use down methods

/*        Student student = Student
                .builder()
                .firstName("milad")
                .lastName("faraji").build();
        em.getTransaction().begin();
        em.persist(student);
        em.getTransaction().commit();
        em.close();*/

