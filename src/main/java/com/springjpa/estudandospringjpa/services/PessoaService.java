package com.springjpa.estudandospringjpa.services;


import com.springjpa.estudandospringjpa.domain.Pessoa;
import com.springjpa.estudandospringjpa.exceptions.ObjectNotFoundException;
import com.springjpa.estudandospringjpa.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository repository;

    public Pessoa buscar(Integer id){
        Optional<Pessoa> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Pessoa não encontrado! Id: " + id + ", Tipo: " + Pessoa.class.getName()));
    }
}
