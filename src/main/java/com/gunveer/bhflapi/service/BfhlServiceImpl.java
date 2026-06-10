package com.gunveer.bhflapi.service;

import com.gunveer.bhflapi.dto.RequestDTO;
import com.gunveer.bhflapi.dto.ResponseDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BfhlServiceImpl implements BfhlService {

    @Override
    public ResponseDTO processData(RequestDTO requestDTO) {

        if (requestDTO == null || requestDTO.getData() == null) {
            throw new RuntimeException("Input data cannot be null");
        }
        List<String> oddNumbers = new ArrayList<>();
        List<String> evenNumbers = new ArrayList<>();
        List<String> alphabets = new ArrayList<>();
        List<String> specialCharacters = new ArrayList<>();

        long sum = 0;
        StringBuilder alphabetCollector = new StringBuilder();

        for (String item : requestDTO.getData()) {

            if (item.matches("\\d+")) {

                int num = Integer.parseInt(item);

                if (num % 2 == 0) {
                    evenNumbers.add(item);
                } else {
                    oddNumbers.add(item);
                }

                sum += num;
            }

            else if (item.matches("[a-zA-Z]+")) {

                alphabets.add(item.toUpperCase());

                alphabetCollector.append(item);
            }

            else {

                specialCharacters.add(item);
            }
        }

        String concatString =
                generateAlternatingCaps(
                        alphabetCollector.toString());

        return ResponseDTO.builder()
                .is_success(true)
                .user_id("gunveer_singh_24052006")
                .email("oberai.gunveer2006@gmail.com")
                .roll_number("23070122098")
                .odd_numbers(oddNumbers)
                .even_numbers(evenNumbers)
                .alphabets(alphabets)
                .special_characters(specialCharacters)
                .sum(String.valueOf(sum))
                .concat_string(concatString)
                .build();
    }

    private String generateAlternatingCaps(String input) {

        String reversed =
                new StringBuilder(input)
                        .reverse()
                        .toString();

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < reversed.length(); i++) {

            char ch = reversed.charAt(i);

            if (i % 2 == 0) {
                result.append(Character.toUpperCase(ch));
            } else {
                result.append(Character.toLowerCase(ch));
            }
        }

        return result.toString();
    }
}