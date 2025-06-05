package com.restaurante.cliente.controller;

import com.restaurante.cliente.model.Cliente;
import com.restaurante.cliente.model.Restaurante;
import com.restaurante.cliente.repository.ClienteRepository;
import com.restaurante.cliente.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private RestTemplate restTemplate;


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
    public ResponseEntity<List<Restaurante>> listarRestaurantesExternos() {
        String url = "https://restaurante-production-7756.up.railway.app/restaurante";

        ResponseEntity<List<Restaurante>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Restaurante>>() {}
        );

        return ResponseEntity.ok(response.getBody());
    }


    @DeleteMapping("/clientes/{id}")
    public ResponseEntity<Void> deletar(@PathVariable String id) {
        clienteRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}