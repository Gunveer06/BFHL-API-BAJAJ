package com.gunveer.bhflapi.service;

import com.gunveer.bhflapi.dto.RequestDTO;
import com.gunveer.bhflapi.dto.ResponseDTO;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class BfhlServiceTest {

    private final BfhlService service = new BfhlServiceImpl();

    @Test
    void testExampleA() {

        RequestDTO request = new RequestDTO();
        request.setData(Arrays.asList(
                "a", "1", "334", "4", "R", "$"
        ));

        ResponseDTO response = service.processData(request);

        assertEquals("339", response.getSum());
        assertEquals("Ra", response.getConcat_string());
        assertEquals(1, response.getOdd_numbers().size());
        assertEquals(2, response.getEven_numbers().size());
    }
    @Test
    void testExampleB() {

        RequestDTO request = new RequestDTO();

        request.setData(Arrays.asList(
                "2", "a", "y", "4",
                "&", "-", "*",
                "5", "92", "b"
        ));

        ResponseDTO response = service.processData(request);

        assertEquals("103", response.getSum());
        assertEquals("ByA", response.getConcat_string());

        assertEquals(
                Arrays.asList("5"),
                response.getOdd_numbers()
        );

        assertEquals(
                Arrays.asList("2", "4", "92"),
                response.getEven_numbers()
        );
    }
    @Test
    void testExampleC() {

        RequestDTO request = new RequestDTO();

        request.setData(Arrays.asList(
                "A", "ABCD", "DOE"
        ));

        ResponseDTO response = service.processData(request);

        assertEquals("0", response.getSum());

        assertEquals(
                "EoDdCbAa",
                response.getConcat_string()
        );

        assertTrue(
                response.getEven_numbers().isEmpty()
        );

        assertTrue(
                response.getOdd_numbers().isEmpty()
        );
    }
    @Test
    void testNullInput() {

        RequestDTO request = new RequestDTO();

        assertThrows(
                RuntimeException.class,
                () -> service.processData(request)
        );
    }
}