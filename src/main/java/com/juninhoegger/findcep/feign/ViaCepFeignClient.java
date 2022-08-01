package com.juninhoegger.findcep.feign;

import com.juninhoegger.findcep.entity.Endereco;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@FeignClient(name = "viaCepFeignClient", url = "https://viacep.com.br/ws")
public interface ViaCepFeignClient {

    @GetMapping(path = "/{cep}/json/", produces = APPLICATION_JSON_VALUE)
    Endereco findByCep(@PathVariable("cep") String cep);

}
