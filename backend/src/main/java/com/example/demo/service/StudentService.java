package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // CREATE
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    // READ ALL
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // READ BY ID
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    // DELETE
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    // =========================
    // UPDATE (PUT)
    // =========================
    public Student updateStudent(Long id, Student updatedStudent) {
        Student existing = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        existing.setName(updatedStudent.getName());
        existing.setEmail(updatedStudent.getEmail());

        return studentRepository.save(existing);
    }

    // =========================
    // PARTIAL UPDATE (PATCH)
    // =========================
    public Student patchStudent(Long id, Student updatedStudent) {
        Student existing = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        if (updatedStudent.getName() != null) {
            existing.setName(updatedStudent.getName());
        }

        if (updatedStudent.getEmail() != null) {
            existing.setEmail(updatedStudent.getEmail());
        }

        return studentRepository.save(existing);
    }
}
