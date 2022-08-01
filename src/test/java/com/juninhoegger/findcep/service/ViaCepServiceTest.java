package com.juninhoegger.findcep.service;

import com.juninhoegger.findcep.entity.Endereco;
import com.juninhoegger.findcep.feign.ViaCepFeignClient;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;

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
        Endereco endereco = viaCepService.findByCep(cep);
        //THEN
        assertNotNull(endereco);
    }

}
