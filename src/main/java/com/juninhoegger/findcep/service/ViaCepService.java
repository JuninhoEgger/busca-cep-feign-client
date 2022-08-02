package com.juninhoegger.findcep.service;

import com.juninhoegger.findcep.entity.Endereco;
import com.juninhoegger.findcep.exception.NotFoundException;
import com.juninhoegger.findcep.feign.ViaCepFeignClient;
import org.springframework.stereotype.Service;

@Service
public class ViaCepService {

    private final ViaCepFeignClient viaCepFeignClient;

    public ViaCepService(ViaCepFeignClient viaCepFeignClient) {
        this.viaCepFeignClient = viaCepFeignClient;
    }

    public Endereco findByCep(String cep) {
        Endereco endereco = viaCepFeignClient.findByCep(cep);
        if (endereco == null) {
            throw new NotFoundException("CEP " + cep + " NOT FOUND");
        }
        return endereco;
    }

}
