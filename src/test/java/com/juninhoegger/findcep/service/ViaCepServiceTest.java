package com.juninhoegger.findcep.service;

import com.juninhoegger.findcep.entity.Endereco;
import com.juninhoegger.findcep.exception.NotFoundException;
import com.juninhoegger.findcep.feign.ViaCepFeignClient;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

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
        Endereco endereco = mockEndereco();

        //WHEN
        when(viaCepFeignClient.findByCep(cep)).thenReturn(endereco);
        Endereco actual = viaCepService.findByCep(cep);

        //THEN
        assertNotNull(actual);
        assertEquals("Rua Cambará do Sul", actual.getLogradouro());
    }

    @Test
    void shouldThrowsExceptionWhenCepIsInvalid() {
        //GIVEN
        String cep = "";
        //WHEN
        //THEN
        assertThrows(NotFoundException.class, () -> viaCepService.findByCep(cep));
    }

    private Endereco mockEndereco() {
        Endereco endereco = new Endereco();
        endereco.setCep("94030210");
        endereco.setLogradouro("Rua Cambará do Sul");
        endereco.setComplemento("");
        endereco.setBairro("COHAB C");
        endereco.setLocalidade("Gravataí");
        endereco.setUf("RS");
        endereco.setIbge("4309209");
        endereco.setGia("");
        endereco.setDdd("51");
        endereco.setSiafi("8683");
        return endereco;
    }
}
