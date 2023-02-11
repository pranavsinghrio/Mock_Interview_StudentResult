package com.example.StudentResult.Repository;

import com.example.StudentResult.Models.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchRepository extends JpaRepository<Branch,Integer> {
    Branch findByBranchName(String branchName);}
