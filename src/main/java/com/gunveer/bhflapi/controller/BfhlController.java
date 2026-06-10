package com.gunveer.bhflapi.controller;

import com.gunveer.bhflapi.dto.RequestDTO;
import com.gunveer.bhflapi.dto.ResponseDTO;
import com.gunveer.bhflapi.service.BfhlService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bfhl")
public class BfhlController {

    private final BfhlService bfhlService;

    public BfhlController(BfhlService bfhlService) {
        this.bfhlService = bfhlService;
    }

    @PostMapping
    public ResponseEntity<ResponseDTO> processData(
            @RequestBody RequestDTO requestDTO) {

        return ResponseEntity.ok(
                bfhlService.processData(requestDTO));
    }
}