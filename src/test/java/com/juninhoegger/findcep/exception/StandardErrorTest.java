package com.juninhoegger.findcep.exception;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@ExtendWith(MockitoExtension.class)
class StandardErrorTest {

    @Test
    void shouldReturnStandardError() {
        //GIVEN
        StandardError actual = mockStandardError();

        //WHEN
        StandardError expected = new StandardError(1L, NOT_FOUND.value(), "NOT FOUND", "OBJECT NOT FOUND", "bugou/tudo");

        //THEN
        assertEquals(expected.getTimeStamp(), actual.getTimeStamp());
        assertEquals(expected.getStatus(), actual.getStatus());
        assertEquals(expected.getError(), actual.getError());
        assertEquals(expected.getMessage(), actual.getMessage());
        assertEquals(expected.getPath(), actual.getPath());
    }

    private StandardError mockStandardError() {
        StandardError standardError = new StandardError();
        standardError.setTimeStamp(1L);
        standardError.setStatus(NOT_FOUND.value());
        standardError.setError("NOT FOUND");
        standardError.setMessage("OBJECT NOT FOUND");
        standardError.setPath("bugou/tudo");
        return standardError;
    }

}
