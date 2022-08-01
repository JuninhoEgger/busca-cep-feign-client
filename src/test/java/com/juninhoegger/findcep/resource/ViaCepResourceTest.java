package com.juninhoegger.findcep.resource;

import com.juninhoegger.findcep.service.ViaCepService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.servlet.http.HttpServletRequest;

import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class ViaCepResourceTest {

    @InjectMocks
    private ViaCepResource viaCepResource;
    @Mock
    private ViaCepService viaCepService;
    @Mock
    private HttpServletRequest request;

    @Test
    void shouldReturnAddressWithCepThroughResource() {
        //GIVEN

        //WHEN
        viaCepResource.findByCep("94030210", request);

        //THEN
        then(viaCepService).should().findByCep("94030210");
    }

}
