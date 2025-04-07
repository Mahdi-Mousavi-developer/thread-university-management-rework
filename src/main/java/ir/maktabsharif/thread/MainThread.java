package ir.maktabsharif.thread;

import ir.maktabsharif.model.Student;
import ir.maktabsharif.repository.Impl.StudentRepository;

import java.util.List;

public class MainThread implements Runnable {

    StudentRepository studentRepository;

    public MainThread(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @Override
    public void run() {
        List<Student> students = studentRepository.findAll();
        int size = students.size();
        while (true) {
            System.out.println(size);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
