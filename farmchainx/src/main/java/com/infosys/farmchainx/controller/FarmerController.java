package com.infosys.farmchainx.controller;

import com.infosys.farmchainx.entity.Farmer;
import com.infosys.farmchainx.service.FarmerService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/farmer")
public class FarmerController {

    private final FarmerService farmerService;

    public FarmerController(FarmerService farmerService) {
        this.farmerService = farmerService;
    }

    @PostMapping("/register")
    public Farmer register(Authentication auth, @RequestBody Farmer farmer) {
        return farmerService.registerFarmer(auth.getName(), farmer);
    }

    @GetMapping("/me")
    public Farmer me(Authentication auth) {
        return farmerService.getMyProfile(auth.getName());
    }
}
