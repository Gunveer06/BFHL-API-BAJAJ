package com.gunveer.bhflapi.controller;

import com.gunveer.bhflapi.dto.RequestDTO;
import com.gunveer.bhflapi.dto.ResponseDTO;
import com.gunveer.bhflapi.service.BfhlService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class BfhlController {

    private final BfhlService bfhlService;

    public BfhlController(BfhlService bfhlService) {
        this.bfhlService = bfhlService;
    }

    @PostMapping("/bfhl")
    public ResponseEntity<ResponseDTO> processData(
            @RequestBody RequestDTO requestDTO) {

        return ResponseEntity.ok(
                bfhlService.processData(requestDTO));
    }

    @GetMapping("/health")
    public ResponseEntity<Map<String, Object>> health() {

        Map<String, Object> response = new HashMap<>();

        response.put("status", "UP");
        response.put("message", "Application is running");

        return ResponseEntity.ok(response);
    }
}