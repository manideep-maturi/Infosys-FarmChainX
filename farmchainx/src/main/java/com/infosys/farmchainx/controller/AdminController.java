package com.infosys.farmchainx.controller;

import com.infosys.farmchainx.dto.AdminDashboardDTO;
import com.infosys.farmchainx.entity.Farmer;
import com.infosys.farmchainx.service.FarmerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final FarmerService farmerService;

    public AdminController(FarmerService farmerService) {
        this.farmerService = farmerService;
    }

    // ADMIN DASHBOARD STATS
    @GetMapping("/dashboard/stats")
    public AdminDashboardDTO getDashboardStats() {
        return farmerService.getDashboardSummary();
    }

    // VIEW ALL APPROVED FARMERS
    @GetMapping("/farmers/approved")
    public List<Farmer> getApprovedFarmers() {
        return farmerService.approvedFarmers();
    }
}
