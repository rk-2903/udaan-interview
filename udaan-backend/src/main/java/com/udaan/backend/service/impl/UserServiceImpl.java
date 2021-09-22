package com.udaan.backend.service.impl;

import com.udaan.backend.model.UserModel;
import com.udaan.backend.repository.UserRepository;
import com.udaan.backend.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public List<UserModel> findAll() {
        return userRepository.findAll();
    }

    @Override
    public String saveUser(UserModel user) {
        UserModel userModel;
        userModel = userRepository.save(user);
        return userModel.getId();
    }

    @Override
    public Integer riskEvaluation(String id, List<String> symptoms, boolean travelHistory, boolean contactWithCovidPatient) {
        int riskPercentage = 0;
        int count = 0;
        Optional<UserModel> user = userRepository.findById(id);
        if (user.isPresent()) {
            user.get().setId(id);
            user.get().setSymptoms(symptoms);
            user.get().setTravelHistory(travelHistory);
            user.get().setContactWithCovidPatient(contactWithCovidPatient);
            userRepository.save(user.get());

            if(user.get().getSymptoms().size() > 0) {
                count++;
            }
            if(user.get().isTravelHistory()) {
                count++;
            }
            if(user.get().isContactWithCovidPatient()) {
                count ++;
            }
            if (count == 0) {
                riskPercentage = 5;
            }
            if (count == 1) {
                riskPercentage = 50;
            }
            if (count == 2) {
                riskPercentage = 75;
            }
            if (count == 3) {
                riskPercentage = 95;
            }
        }
        return riskPercentage;
    }
}
