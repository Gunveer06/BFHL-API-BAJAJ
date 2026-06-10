package com.gunveer.bhflapi.service;

import com.gunveer.bhflapi.dto.RequestDTO;
import com.gunveer.bhflapi.dto.ResponseDTO;

public interface BfhlService {
    ResponseDTO processData(RequestDTO requestDTO);
}