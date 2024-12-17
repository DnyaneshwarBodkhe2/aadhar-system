package com.aadhar.system.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class CitizenDTO {

        private String aadharId;

        private String panId;

        private String name;
}
