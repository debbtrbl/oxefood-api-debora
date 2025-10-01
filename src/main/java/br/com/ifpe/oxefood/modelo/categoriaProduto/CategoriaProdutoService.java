package br.com.ifpe.oxefood.modelo.categoriaProduto;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

@Service
public class CategoriaProdutoService {

   @Autowired
   private CategoriaProdutoRepository repository; 

   @Transactional
   public CategoriaProduto save(CategoriaProduto categoriaProduto) {

       categoriaProduto.setHabilitado(Boolean.TRUE); // habilita o categoriaProduto por padrão
       return repository.save(categoriaProduto); // insere no banco de dados
   }

   public List<CategoriaProduto> listarTodos() {
        return repository.findAll(); // select * from categoriaProduto
    }

    public CategoriaProduto obterPorID(Long id) {
        return repository.findById(id).get(); // select * from categoriaProduto where id = ?
    }

    @Transactional
    public void update(Long id, CategoriaProduto categoriaProdutoAlterado) {

      CategoriaProduto categoriaProduto = repository.findById(id).get();
      categoriaProduto.setDescricao(categoriaProdutoAlterado.getDescricao());

      repository.save(categoriaProduto);
  }

    @Transactional
    public void delete(Long id) {

       CategoriaProduto categoriaProduto = repository.findById(id).get();
       categoriaProduto.setHabilitado(Boolean.FALSE);

       repository.save(categoriaProduto);
   }




}
