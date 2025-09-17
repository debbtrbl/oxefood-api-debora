package br.com.ifpe.oxefood.modelo.produto;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

   @Autowired
   private ProdutoRepository repository; 

   @Transactional
   public Produto save(Produto produto) {

       produto.setHabilitado(Boolean.TRUE); // habilita o produto por padrão
       return repository.save(produto); // insere no banco de dados
   }

}
