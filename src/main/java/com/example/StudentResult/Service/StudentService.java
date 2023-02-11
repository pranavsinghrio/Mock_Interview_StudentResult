package com.example.StudentResult.Service;

import com.example.StudentResult.Dto.StudentRequestDto;
import com.example.StudentResult.Models.Branch;
import com.example.StudentResult.Models.Student;
import com.example.StudentResult.Repository.BranchRepository;
import com.example.StudentResult.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class StudentService {


    @Autowired
    StudentRepository studentRepository;

    @Autowired
    BranchRepository branchRepository;


    public void addStudent(StudentRequestDto studentRequestDto){

        Branch branch=branchRepository.findById(studentRequestDto.getBranchId()).get();

        Student student=Student.builder().name(studentRequestDto.getName()).marks(studentRequestDto.getMarks())
                .branchName(branch.getBranchName()).rollNo(studentRequestDto.getRollNo())
                .build();

        student.setBranch(branch);

        //bidirectional
        branch.getStudentList().add(student);


        branchRepository.save(branch);
    }

    public List<String> getStudentRollNo(){
        Date date=new Date(Long.MIN_VALUE);

        List<String> result=new ArrayList<>();

        List<Branch> branchList=branchRepository.findAll();

        Branch recentlyAddedBranch=null;

        for(Branch branch:branchList){
            if(branch.getAddedDate().after(date)){
                date=branch.getAddedDate();
                recentlyAddedBranch=branch;
            }
        }
        assert recentlyAddedBranch != null;
        for(Student student:recentlyAddedBranch.getStudentList()){
            result.add(student.getRollNo());
        }
        return result;
    }

}