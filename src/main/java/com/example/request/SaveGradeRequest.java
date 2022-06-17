package com.example.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
public class SaveGradeRequest {

    @NotNull(message = "course required")
    private String course;
    @NotNull(message = "grade required")
    private Double grade;
    @NotNull(message = "userCode required")
    private String userCode;
    private int status;
}
