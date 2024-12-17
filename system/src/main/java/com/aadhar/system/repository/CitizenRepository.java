package com.aadhar.system.repository;

import com.aadhar.system.entity.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CitizenRepository extends JpaRepository<Citizen,String> {
    Optional<Citizen>findByPanId(String panId);
}
