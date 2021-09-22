package com.udaan.backend.controller;

import com.udaan.backend.model.UserModel;
import com.udaan.backend.service.IUserService;
import com.udaan.backend.service.RiskCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private RiskCalculatorService riskCalculatorService;

    @GetMapping("/user")
    public ResponseEntity<List<UserModel>> findAll() {
        return ResponseEntity.ok().body(userService.findAll());
    }

    @PostMapping("/user")
    public ResponseEntity<String> saveUser(@RequestBody UserModel user) {
        return ResponseEntity.ok().body(userService.saveUser(user));
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<Integer> riskEvaluation(@PathVariable String id,
                                                    @RequestParam List<String> symptoms,
                                                    @RequestParam boolean travelHistory,
                                                    @RequestParam boolean contactWithCovidPatient) {
        return ResponseEntity.ok().body(userService.riskEvaluation(id, symptoms, travelHistory, contactWithCovidPatient));
    }
}
