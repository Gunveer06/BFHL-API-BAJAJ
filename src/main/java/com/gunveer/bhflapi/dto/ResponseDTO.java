package com.gunveer.bhflapi.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@JsonPropertyOrder({
        "is_success",
        "user_id",
        "email",
        "roll_number",
        "odd_numbers",
        "even_numbers",
        "alphabets",
        "special_characters",
        "sum",
        "concat_string"
})
public class ResponseDTO {

    private boolean is_success;

    private String user_id;

    private String email;

    private String roll_number;

    private List<String> odd_numbers;

    private List<String> even_numbers;

    private List<String> alphabets;

    private List<String> special_characters;

    private String sum;

    private String concat_string;
}