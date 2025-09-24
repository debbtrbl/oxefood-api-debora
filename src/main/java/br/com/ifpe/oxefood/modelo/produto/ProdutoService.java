package br.com.ifpe.oxefood.modelo.produto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

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

     @Transactional
    public void update(Long id, Produto produtoAlterado) {

      Produto produto = repository.findById(id).get();
      produto.setCodigo(produtoAlterado.getCodigo());
      produto.setTitulo(produtoAlterado.getTitulo());
      produto.setDescricao(produtoAlterado.getDescricao());
      produto.setValorUnitario(produtoAlterado.getValorUnitario());
      produto.setTempoEntregaMinimo(produtoAlterado.getTempoEntregaMinimo());
      produto.setTempoEntregaMaximo(produtoAlterado.getTempoEntregaMaximo());
      
      repository.save(produto);
  }


}
