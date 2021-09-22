package com.udaan.backend.service;

import com.udaan.backend.model.UserModel;

import java.util.List;

public interface IUserService {
    List<UserModel> findAll();

    String saveUser(UserModel user);

    Integer riskEvaluation(String id, List<String> symptoms, boolean travelHistory, boolean contactWithCovidPatient);
}
