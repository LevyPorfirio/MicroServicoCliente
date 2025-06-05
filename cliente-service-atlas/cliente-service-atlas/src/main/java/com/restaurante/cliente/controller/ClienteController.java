package com.restaurante.cliente.controller;

import com.restaurante.cliente.model.Cliente;
import com.restaurante.cliente.model.Restaurante;
import com.restaurante.cliente.repository.ClienteRepository;
import com.restaurante.cliente.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/clientes")
    public ResponseEntity<List<Cliente>> listarTodos() {
        return ResponseEntity.ok(clienteRepository.findAll());
    }

    @PostMapping("/clientes")
    public ResponseEntity<Cliente> cadastrar(@RequestBody Cliente cliente) {
        return ResponseEntity.ok(clienteService.cadastrar(cliente));
    }

    @PutMapping("/clientes/{id}")
    public ResponseEntity<Cliente> atualizar(@PathVariable String id, @RequestBody Cliente cliente) {
        return clienteService.atualizar(id, cliente)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/restaurantes")
    public ResponseEntity<List<Restaurante>> listarRestaurantes() {
        List<Restaurante> restaurantes = Arrays.asList(
                new Restaurante("Pizza Rápida", "Italiana", "Av. Central, 101"),
                new Restaurante("Sushi Bom", "Japonesa", "Rua do Sol, 88"),
                new Restaurante("Churrasquim", "Brasileira", "Estrada 23, 500")
        );
        return ResponseEntity.ok(restaurantes);
    }
}