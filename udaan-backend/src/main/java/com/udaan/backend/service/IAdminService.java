package com.udaan.backend.service;

import com.udaan.backend.model.AdminModel;

import java.util.List;

public interface IAdminService {
    List<AdminModel> findAll();

    String saveAdmin(AdminModel adminModel);

    Boolean updateCovidResult(String userId, String id, String result);
}