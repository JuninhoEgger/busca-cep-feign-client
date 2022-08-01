package com.juninhoegger.findcep.service;

import com.juninhoegger.findcep.entity.Endereco;
import com.juninhoegger.findcep.feign.ViaCepFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ViaCepService {

    @Autowired
    private ViaCepFeignClient viaCepFeignClient;

    public Endereco findByCep(String cep) {
        return viaCepFeignClient.findByCep(cep);
    }

}
