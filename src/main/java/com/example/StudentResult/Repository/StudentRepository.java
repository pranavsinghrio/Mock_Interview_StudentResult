package com.example.StudentResult.Repository;

import com.example.StudentResult.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {
}
