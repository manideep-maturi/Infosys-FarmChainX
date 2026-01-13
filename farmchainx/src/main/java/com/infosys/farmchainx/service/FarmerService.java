package com.infosys.farmchainx.service;

import com.infosys.farmchainx.entity.*;
import com.infosys.farmchainx.dto.AdminDashboardDTO;

import com.infosys.farmchainx.repository.*;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FarmerService {

    private final FarmerRepository farmerRepo;
    private final UserRepository userRepo;

    public FarmerService(FarmerRepository farmerRepo,
                         UserRepository userRepo) {
        this.farmerRepo = farmerRepo;
        this.userRepo = userRepo;
    }

    public Farmer registerFarmer(String email, Farmer farmer) {
        User user = userRepo.findByEmail(email).orElseThrow();
        farmer.setUser(user);
        farmer.setStatus(FarmerStatus.PENDING);
        return farmerRepo.save(farmer);
    }

    public Farmer getMyProfile(String email) {
        User user = userRepo.findByEmail(email).orElseThrow();
        return farmerRepo.findByUser(user).orElseThrow();
    }

    // ADMIN DASHBOARD SUMMARY
    public AdminDashboardDTO getDashboardSummary() {
        return new AdminDashboardDTO(
                farmerRepo.countByStatus(FarmerStatus.PENDING),
                farmerRepo.countByStatus(FarmerStatus.APPROVED),
                farmerRepo.countByStatus(FarmerStatus.REJECTED)
        );
    }

    public List<Farmer> approvedFarmers() {
        return farmerRepo.findByStatus(FarmerStatus.APPROVED);
    }
}
