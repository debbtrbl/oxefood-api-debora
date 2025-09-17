package br.com.ifpe.oxefood.modelo.cliente;

import org.springframework.data.jpa.repository.JpaRepository;

// <Cliente, Long> - Long é o tipo da chave primaria da entidade Cliente
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
}
