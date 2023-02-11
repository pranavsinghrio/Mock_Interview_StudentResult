package com.example.StudentResult.Models;
import com.example.StudentResult.Enum.BranchName;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String rollNo;

    private String name;

    @Enumerated(EnumType.STRING)
    private BranchName branchName;

    private int marks;


    @ManyToOne
    @JoinColumn
    private Branch branch;

}