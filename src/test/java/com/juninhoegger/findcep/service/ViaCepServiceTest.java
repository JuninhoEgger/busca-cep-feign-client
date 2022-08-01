package com.juninhoegger.findcep.service;

import com.juninhoegger.findcep.feign.ViaCepFeignClient;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ViaCepServiceTest {

    @InjectMocks
    private ViaCepService viaCepService;

    @Mock
    private ViaCepFeignClient viaCepFeignClient;

    //TODO
//    @Test
//    void shouldReturnAddressWithCep() {
//        //GIVEN
//        Endereco endereco;
//
//        //WHEN
//        endereco = viaCepService.findByCep("94030210");
//
//        //THEN
//        assertEquals("Rua Cambará do Sul", endereco.getLogradouro());
//    }

}
