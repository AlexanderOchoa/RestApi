package com.example.controller;

import com.example.request.SaveGradeRequest;
import com.example.response.ListGradeResponse;
import com.example.response.SaveGradeResponse;
import com.example.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/v1/grades")
public class GradeController {

    private GradeService gradeService;

    @Autowired
    public GradeController(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    @GetMapping
    public @ResponseBody ResponseEntity<ListGradeResponse> list() {
        ListGradeResponse response = gradeService.list();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public @ResponseBody ResponseEntity<SaveGradeResponse> register(@Valid @RequestBody SaveGradeRequest request) {
        SaveGradeResponse response = gradeService.register(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
