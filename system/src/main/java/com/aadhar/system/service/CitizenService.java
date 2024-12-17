package com.aadhar.system.service;

import com.aadhar.system.dto.CitizenDTO;
import com.aadhar.system.entity.Citizen;
import com.aadhar.system.repository.CitizenRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CitizenService {
    @Autowired
    private CitizenRepository citizenRepository;

    public void addCitizen(CitizenDTO dto) {
        Citizen citizen = new Citizen();
        BeanUtils.copyProperties(dto, citizen);
        citizenRepository.save(citizen);
    }

    public CitizenDTO getByAadhar(String aadharId) {
        Citizen citizen = citizenRepository.findById(aadharId)
                .orElseThrow(() -> new RuntimeException("Citizen not found"));
        return mapToDTO(citizen);
    }

    public CitizenDTO getByPan(String panId) {
        Citizen citizen = citizenRepository.findByPanId(panId)
                .orElseThrow(() -> new RuntimeException("Citizen not found"));
        return mapToDTO(citizen);
    }

    public void updateName(String aadharId, String name) {
        Citizen citizen = citizenRepository.findById(aadharId)
                .orElseThrow(() -> new RuntimeException("Citizen not found"));
        citizen.setName(name);
        citizenRepository.save(citizen);
    }

    private CitizenDTO mapToDTO(Citizen citizen) {
        CitizenDTO dto = new CitizenDTO();
        BeanUtils.copyProperties(citizen, dto);
        return dto;
    }
}
