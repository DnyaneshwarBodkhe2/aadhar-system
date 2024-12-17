package com.aadhar.system.controller;

import com.aadhar.system.dto.CitizenDTO;
import com.aadhar.system.service.CitizenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class CitizenController {

        @Autowired
        private CitizenService citizenService;

        @PostMapping("/citizen")
        public ResponseEntity<String> addCitizen(@RequestBody CitizenDTO dto) {
            citizenService.addCitizen(dto);
            return ResponseEntity.ok("Citizen added successfully");
        }

        @GetMapping("/{aadharId}")
        public ResponseEntity<CitizenDTO> getByAadhar(@PathVariable String aadharId) {
            return ResponseEntity.ok(citizenService.getByAadhar(aadharId));
        }

        @GetMapping("/pan/{panId}")
        public ResponseEntity<CitizenDTO> getByPan(@PathVariable String panId) {
            return ResponseEntity.ok(citizenService.getByPan(panId));
        }

        @PutMapping("/{aadharId}")
        public ResponseEntity<String> updateName(@PathVariable String aadharId, @RequestParam String name) {
            citizenService.updateName(aadharId, name);
            return ResponseEntity.ok("Name updated successfully");
        }

}
