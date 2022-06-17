package com.example.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class GradeDTO {

    private String course;
    private Double grade;
    private String userCode;
    private String user;
    private int status;
}
