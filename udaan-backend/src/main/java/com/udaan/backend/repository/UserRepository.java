package com.udaan.backend.repository;

import com.udaan.backend.model.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<UserModel, String> {

    List<UserModel> findAllByPinCode(String pinCode);
}
