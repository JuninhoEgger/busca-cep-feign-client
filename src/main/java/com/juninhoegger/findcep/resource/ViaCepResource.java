package com.juninhoegger.findcep.resource;

import com.juninhoegger.findcep.api.ViaCepApi;
import com.juninhoegger.findcep.entity.Endereco;
import com.juninhoegger.findcep.service.ViaCepService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.http.ResponseEntity.ok;

@Slf4j
@Controller
@Api(tags = {"Address"})
public class ViaCepResource implements ViaCepApi {

    @Autowired
    private ViaCepService viaCepService;

    @Override
    public ResponseEntity<Endereco> findByCep(String cep, HttpServletRequest request) {
        log.info("Buscando o endereço completo do cep {}", cep);
        return ok().body(viaCepService.findByCep(cep));
    }
}
