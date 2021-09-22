package com.udaan.backend.service.impl;

import com.udaan.backend.dto.ZoneWiseResult;
import com.udaan.backend.model.AdminModel;
import com.udaan.backend.model.UserModel;
import com.udaan.backend.model.Zones;
import com.udaan.backend.repository.AdminRepository;
import com.udaan.backend.repository.UserRepository;
import com.udaan.backend.service.IAdminService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AdminServiceImpl implements IAdminService {

    private final AdminRepository adminRepository;
    private final UserRepository  userRepository;


    public AdminServiceImpl(AdminRepository adminRepository, UserRepository userRepository) {
        this.adminRepository = adminRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<AdminModel> findAll() {
        return adminRepository.findAll();
    }

    @Override
    public String saveAdmin(AdminModel admin) {
        return adminRepository.save(admin).getId();
    }

    @Override
    public Boolean updateCovidResult(String userId, String id, String result) {
        try {
            userRepository.findById(userId).get().setCovidResult(result);
        } catch ( Exception e) {
            System.out.println("Error while updating the user"  + e.getMessage());
        }
        return true;
    }

    @Override
    public ZoneWiseResult updateZones(String pinCode) {
        Map<String, Long> map = userRepository.findAllByPinCode(pinCode)
                .stream()
                .filter(UserModel::filterPositiveCases)
                .collect(Collectors.groupingBy(UserModel::getPinCode, Collectors.counting()));
        if(map.get(pinCode)> 5) {
            return new ZoneWiseResult(map.get(pinCode).toString(),"RED");
        }
        if(map.get(pinCode) < 5 ){
            return new ZoneWiseResult(map.get(pinCode).toString(),"ORANGE");
        }
        return new ZoneWiseResult(map.get(pinCode).toString(),"GREEN");
    }
}
