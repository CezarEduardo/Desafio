package com.backend.financeiro.model.entity.repository;

import com.backend.financeiro.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository  extends JpaRepository<Cliente, Integer>{
}
