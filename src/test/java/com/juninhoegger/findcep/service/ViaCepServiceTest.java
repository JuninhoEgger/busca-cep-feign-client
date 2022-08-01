package com.juninhoegger.findcep.service;

import com.juninhoegger.findcep.entity.Endereco;
import com.juninhoegger.findcep.exception.NotFoundException;
import com.juninhoegger.findcep.feign.ViaCepFeignClient;
import com.juninhoegger.findcep.resource.ViaCepResource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.http.HttpServletRequest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class ViaCepServiceTest {

    @InjectMocks
    private ViaCepService viaCepService;
    @Mock
    private ViaCepFeignClient viaCepFeignClient;
    
    @Test
    void shouldReturnAddressWithCep() {
        //GIVEN
        String cep = "94030210";

        //WHEN
        String expected = "Rua Cambará do Sul";
        Endereco endereco = viaCepService.findByCep(cep);

        //THEN
        assertEquals(expected, endereco.getLogradouro());
    }

    @Test
    void shouldThrowsExceptionWhenCepIsInvalid() {
        //GIVEN
        String cep = "";
        //WHEN
        //THEN
        assertThrows(NotFoundException.class, () -> viaCepService.findByCep(cep));
    }

}
