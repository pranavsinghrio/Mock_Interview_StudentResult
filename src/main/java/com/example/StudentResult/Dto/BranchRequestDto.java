package com.example.StudentResult.Dto;

import com.example.StudentResult.Enum.BranchName;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BranchRequestDto {

    @Enumerated(EnumType.STRING)
    private BranchName branchName;

    private String hodName;

    private String contactNo;

    private Date addedDate;

}