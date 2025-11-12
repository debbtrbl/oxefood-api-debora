package br.com.ifpe.oxefood.modelo.produto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.ifpe.oxefood.util.Util;
import br.com.ifpe.oxefood.util.exception.ProdutoException;
import jakarta.transaction.Transactional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    @Transactional
    public Produto save(Produto produto) {

        if (produto.getValorUnitario() < 20 || produto.getValorUnitario() > 100) {
            throw new ProdutoException(ProdutoException.MSG_VALOR_MIN_MAX_PRODUTO);
        }

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
        produto.setCategoria(produtoAlterado.getCategoria());
        produto.setCodigo(produtoAlterado.getCodigo());
        produto.setTitulo(produtoAlterado.getTitulo());
        produto.setDescricao(produtoAlterado.getDescricao());
        produto.setValorUnitario(produtoAlterado.getValorUnitario());
        produto.setTempoEntregaMinimo(produtoAlterado.getTempoEntregaMinimo());
        produto.setTempoEntregaMaximo(produtoAlterado.getTempoEntregaMaximo());

        repository.save(produto);
    }

    @Transactional
    public void delete(Long id) {

        Produto produto = repository.findById(id).get();
        produto.setHabilitado(Boolean.FALSE);

        repository.save(produto);
    }

    public List<Produto> filtrar(String codigo, String titulo, Long idCategoria) {

        // Se nenhum filtro foi informado, retorna todos
        if ((codigo == null || codigo.trim().isEmpty()) &&
                (titulo == null || titulo.trim().isEmpty()) &&
                (idCategoria == null)) {
            return repository.findAll();
        }

        // Filtro apenas por código
        if (codigo != null && !codigo.trim().isEmpty() &&
                (titulo == null || titulo.trim().isEmpty()) &&
                idCategoria == null) {
            return repository.consultarPorCodigo(codigo);
        }

        // Filtro apenas por título
        if ((codigo == null || codigo.trim().isEmpty()) &&
                titulo != null && !titulo.trim().isEmpty() &&
                idCategoria == null) {
            return repository.findByTituloContainingIgnoreCaseOrderByTituloAsc(titulo);
        }

        // Filtro apenas por categoria
        if ((codigo == null || codigo.trim().isEmpty()) &&
                (titulo == null || titulo.trim().isEmpty()) &&
                idCategoria != null) {
            return repository.consultarPorCategoria(idCategoria);
        }

        // Filtro por título E categoria
        if ((codigo == null || codigo.trim().isEmpty()) &&
                titulo != null && !titulo.trim().isEmpty() &&
                idCategoria != null) {
            return repository.consultarPorTituloECategoria(titulo, idCategoria);
        }

        // Para outros casos de combinação de filtros, retorna vazio
        // ou implemente mais métodos no repository conforme necessidade
        return List.of();
    }

    @Transactional
    public Produto saveImage(Long id, MultipartFile imagem) {

        Produto produto = obterPorID(id);

        String imagemUpada = Util.fazerUploadImagem(imagem);

        if (imagemUpada != null) {
            produto.setImagem(imagemUpada);
        }

        return save(produto);
    }

}
