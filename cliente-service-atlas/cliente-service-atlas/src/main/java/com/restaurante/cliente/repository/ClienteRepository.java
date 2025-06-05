package com.restaurante.cliente.repository;

import com.restaurante.cliente.model.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClienteRepository extends MongoRepository<Cliente, String> {}