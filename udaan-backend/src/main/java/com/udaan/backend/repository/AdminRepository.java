package com.udaan.backend.repository;

import com.udaan.backend.model.AdminModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends MongoRepository<AdminModel, String> {
}
