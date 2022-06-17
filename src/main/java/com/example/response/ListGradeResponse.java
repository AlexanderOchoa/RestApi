package com.example.response;

import com.example.dto.GradeDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class ListGradeResponse {

    private List<GradeDTO> grades;
}
