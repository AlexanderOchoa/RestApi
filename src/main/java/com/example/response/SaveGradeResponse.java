package com.example.response;

import com.example.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
public class SaveGradeResponse {

    private Long idGrade;
    private String course;
    private Double grade;
    private String userCode;
    private int status;
}
