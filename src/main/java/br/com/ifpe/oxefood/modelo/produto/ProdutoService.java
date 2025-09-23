package br.com.ifpe.oxefood.modelo.produto;

import jakarta.transaction.Transactional;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifpe.oxefood.modelo.cliente.Cliente;

@Service
public class ProdutoService {

   @Autowired
   private ProdutoRepository repository; 

   @Transactional
   public Produto save(Produto produto) {

       produto.setHabilitado(Boolean.TRUE); // habilita o produto por padrão
       return repository.save(produto); // insere no banco de dados
   }

   public List<Produto> listarTodos() {
        return repository.findAll(); // select * from produto
    }

    public Produto obterPorID(Long id) {
        return repository.findById(id).get(); // select * from produto where id = ?
    }


}
