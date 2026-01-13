package com.infosys.farmchainx.repository;

import com.infosys.farmchainx.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FarmerRepository extends JpaRepository<Farmer, Long> {

    List<Farmer> findByStatus(FarmerStatus status);

    Optional<Farmer> findByUser(User user);

    long countByStatus(FarmerStatus status);
}
