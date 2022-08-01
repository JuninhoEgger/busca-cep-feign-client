package com.juninhoegger.findcep.exception;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.ResponseEntity.status;

@ExtendWith(MockitoExtension.class)
class ResourceExceptionHandlerTest {

    @InjectMocks
    ResourceExceptionHandler exceptionHandler;

    @Test
    void shouldTestNotFoundExceptionHandler() {
        //GIVEN
        HttpServletRequest request = mockServletRequest();
        NotFoundException ex = mock(NotFoundException.class);
        StandardError standardError = mock(StandardError.class);

        //WHEN
        ResponseEntity<StandardError> actual = exceptionHandler.objectNotFound(ex, request);
        ResponseEntity<StandardError> expected = status(NOT_FOUND).body(standardError);

        //THEN
        assertEquals(expected.getStatusCode(), actual.getStatusCode());
    }

    private HttpServletRequest mockServletRequest() {
        HttpServletRequest request = mock(HttpServletRequest.class);

        given(request.getRequestURI()).willReturn("request-uri");

        return request;
    }

}
