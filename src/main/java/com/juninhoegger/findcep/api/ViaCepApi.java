package com.juninhoegger.findcep.api;

import com.juninhoegger.findcep.entity.Endereco;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Api("Address")
@RequestMapping("/address")
public interface ViaCepApi {

    @ApiOperation(
            value = "Busca um endereço conforme um cep informado",
            nickname = "findByCep",
            notes = "Busca o endereço conforme o CEP informado caso exista",
            response = Endereco.class
    )
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Endereco.class)})
    @GetMapping(value = "findbycep/{cep}", produces = APPLICATION_JSON_VALUE)
    ResponseEntity<Endereco> findByCep(@PathVariable("cep") String cep, HttpServletRequest request);
}
