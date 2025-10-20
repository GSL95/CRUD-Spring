package com.DEV.CRUDClientes.controller;

import com.DEV.CRUDClientes.model.Cliente;
import com.DEV.CRUDClientes.repository.ClienteRepository;
import com.DEV.CRUDClientes.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente")

public class ClienteController {

    private final ClienteService clienteService;
    public ClienteController(ClienteService p_clienteService)
    {
        this.clienteService = p_clienteService;
    }
    @PostMapping
    public ResponseEntity<Void> createCliente(@RequestBody Cliente cliente)
    {
        clienteService.createCliente((cliente));
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Cliente> searchClienteByEmail(@RequestParam String email)
    {
        return ResponseEntity.ok(clienteService.searchClientebyEmail(email));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteClienteByEmail(@RequestParam String email)
    {
        clienteService.deleteClienteByEmail(email);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> updateClienteByEmail(@RequestParam String email, @RequestBody Cliente cliente)
    {
        clienteService.updateClienteByEmail(email, cliente);
        return ResponseEntity.ok().build();
    }
}
