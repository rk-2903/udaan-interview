package com.udaan.backend.controller;

import com.udaan.backend.model.AdminModel;
import com.udaan.backend.model.Zones;
import com.udaan.backend.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AdminController {

    @Autowired
    private IAdminService adminService;

    @GetMapping("/admin")
    public ResponseEntity<List<AdminModel>> getAllAdmin() {
        return ResponseEntity.ok().body(adminService.findAll());
    }

    @PostMapping("/admin")
    public ResponseEntity<String> saveAdmin(@RequestBody AdminModel admin) {
        return ResponseEntity.ok().body(adminService.saveAdmin(admin));
    }

    @PatchMapping("/admin/{id}")
    public ResponseEntity<Boolean> updateCovidResult(@RequestParam String userId,
                                                     @PathVariable String id,
                                                     @RequestParam String result) {
        return ResponseEntity.ok().body(adminService.updateCovidResult(userId, id, result));
    }

    @PostMapping("admin/evaluate-positive-cases")
    public ResponseEntity<Zones> updateZones () {
        return ResponseEntity.ok().body(adminService.updateZones());
    }

}
