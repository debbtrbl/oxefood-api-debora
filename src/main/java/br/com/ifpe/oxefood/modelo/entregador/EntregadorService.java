package br.com.ifpe.oxefood.modelo.entregador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifpe.oxefood.modelo.cliente.Cliente;
import jakarta.transaction.Transactional;

@Service
public class EntregadorService {
    
    @Autowired
    private EntregadorRepository repository;

    @Transactional
    public Entregador save(Entregador entregador) {

        entregador.setHabilitado(Boolean.TRUE); // habilita o entregador por padrão
        return repository.save(entregador); // insere no banco de dados
    }

    public List<Entregador> listarTodos() {
        return repository.findAll(); // select * from entregador
    }

    public Entregador obterPorID(Long id) {
        return repository.findById(id).get(); // select * from entregador where id = ?
    }
}
