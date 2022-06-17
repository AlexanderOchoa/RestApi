package com.example.service.impl;

import com.example.dto.GradeDTO;
import com.example.entity.Grade;
import com.example.entity.User;
import com.example.repository.GradeRepository;
import com.example.repository.UserRepository;
import com.example.request.SaveGradeRequest;
import com.example.response.ListGradeResponse;
import com.example.response.SaveGradeResponse;
import com.example.service.GradeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GradeServiceImpl implements GradeService {

    private GradeRepository gradeRepository;
    private UserRepository userRepository;

    @Autowired
    public GradeServiceImpl(GradeRepository gradeRepository, UserRepository userRepository) {
        this.gradeRepository = gradeRepository;
        this.userRepository = userRepository;
    }

    @Override
    public ListGradeResponse list() {
        List<Grade> listGrade = gradeRepository.findAll();

        return getListGradeResponse(listGrade);
    }

    @Override
    public SaveGradeResponse register(SaveGradeRequest request) {
        User user = userRepository.findByCode(request.getUserCode());

        Grade grade = gradeRepository.save(getGrade(user, request));

        return getSaveGradeResponse(grade);
    }

    private Grade getGrade(User user, SaveGradeRequest request) {
        Grade grade = new Grade();
        BeanUtils.copyProperties(request, grade);
        grade.setUser(user);
        return grade;
    }

    private SaveGradeResponse getSaveGradeResponse(Grade grade) {
        SaveGradeResponse response = new SaveGradeResponse();
        BeanUtils.copyProperties(grade, response);
        response.setUserCode(grade.getUser().getCode());
        return response;
    }

    private ListGradeResponse getListGradeResponse(List<Grade> listGrade) {
        ListGradeResponse listGradeResponse = new ListGradeResponse();
        List<GradeDTO> gradeDTOS = new ArrayList<>();

        listGrade.forEach(grade -> {
            GradeDTO gradeDTO = new GradeDTO();
            BeanUtils.copyProperties(grade, gradeDTO);
            gradeDTO.setUserCode(grade.getUser().getCode());
            gradeDTO.setUser(grade.getUser().getNames());
            gradeDTOS.add(gradeDTO);
        });

        listGradeResponse.setGrades(gradeDTOS);

        return listGradeResponse;
    }

}
