package com.juninhoegger.findcep.entitytest;

import com.juninhoegger.findcep.entity.Endereco;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class EnderecoTest {

    @Test
    void shouldReturnCorrectlyAddress() {
        //GIVEN
        Endereco endereco = mockEndereco();
        //WHEN
        //THEN
        assertEquals("94030210", endereco.getCep());
        assertEquals("Rua Cambará do Sul", endereco.getLogradouro());
        assertEquals("", endereco.getComplemento());
        assertEquals("COHAB C", endereco.getBairro());
        assertEquals("Gravataí", endereco.getLocalidade());
        assertEquals("RS", endereco.getUf());
        assertEquals("4309209", endereco.getIbge());
        assertEquals("", endereco.getGia());
        assertEquals("51", endereco.getDdd());
        assertEquals("8683", endereco.getSiafi());
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
