package com.DEV.CRUDClientes.service;

import com.DEV.CRUDClientes.model.Cliente;
import com.DEV.CRUDClientes.repository.ClienteRepository;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;
    public ClienteService(ClienteRepository p_clienteRepository)
    {
        this.clienteRepository = p_clienteRepository;
    }

    public void createCliente(Cliente p_cliente)
    {
        clienteRepository.saveAndFlush(p_cliente);
    }

    public Cliente searchClientebyEmail(String email)
    {
        return clienteRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Email não encontrado"));
    }

    public void deleteClienteByEmail(String email)
    {
        clienteRepository.deleteByEmail(email);
    }

    public void updateClienteByEmail(String email, Cliente cliente)
    {
        Cliente clienteEntity = searchClientebyEmail(email);
        Cliente updatedCliente = Cliente.builder()
                .email(email)
                .nome(cliente.getNome() != null ? cliente.getNome() : clienteEntity.getNome())
                .id(cliente.getId())
                .cpf(cliente.getCpf())
                .build();
        clienteRepository.saveAndFlush(updatedCliente);
    }
}
