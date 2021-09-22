package com.udaan.backend.service;

import com.udaan.backend.dto.ZoneWiseResult;
import com.udaan.backend.model.AdminModel;
import com.udaan.backend.model.Zones;

import java.util.List;

public interface IAdminService {
    List<AdminModel> findAll();

    String saveAdmin(AdminModel adminModel);

    Boolean updateCovidResult(String userId, String id, String result);

    ZoneWiseResult updateZones(String pinCode);
}
