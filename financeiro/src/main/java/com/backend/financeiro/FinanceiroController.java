package com.backend.financeiro;

import com.backend.financeiro.model.entity.Cliente;
import com.backend.financeiro.model.entity.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class FinanceiroController {

    private ClienteRepository repository;

    @Autowired
    public FinanceiroController( ClienteRepository repository){
        this.repository = repository;
    }

    @GetMapping
    public List<Cliente> obterTodos(){
        return repository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente salvar (@RequestBody Cliente cliente){
        return repository.save(cliente);
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar (@PathVariable Integer id){
        repository.findById(id).map(cliente -> {
            repository.delete(cliente);
            return Void.TYPE;
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar (@PathVariable Integer id, @RequestBody Cliente clienteAtualizado){
        repository.findById(id).map( cliente -> {
            cliente.setNome(cliente.getNome());
            cliente.setCpf(cliente.getCpf());

            return repository.save(clienteAtualizado);
        }).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
    }
}
