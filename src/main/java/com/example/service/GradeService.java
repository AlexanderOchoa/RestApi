package com.example.service;

import com.example.request.SaveGradeRequest;
import com.example.response.ListGradeResponse;
import com.example.response.SaveGradeResponse;

public interface GradeService {
    ListGradeResponse list();
    SaveGradeResponse register(SaveGradeRequest request);
}
