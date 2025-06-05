package com.restaurante.cliente.service;

import com.restaurante.cliente.model.Cliente;
import com.restaurante.cliente.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente cadastrar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Optional<Cliente> atualizar(String id, Cliente dadosAtualizados) {
        return clienteRepository.findById(id).map(cliente -> {
            cliente.setNome(dadosAtualizados.getNome());
            cliente.setEmail(dadosAtualizados.getEmail());
            cliente.setTelefone(dadosAtualizados.getTelefone());
            cliente.setEndereco(dadosAtualizados.getEndereco());
            return clienteRepository.save(cliente);
        });
    }
}