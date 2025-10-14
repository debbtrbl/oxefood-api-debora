package br.com.ifpe.oxefood.modelo.cidade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import jakarta.transaction.Transactional;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository repository; 

    @Transactional
    public Cidade save(Cidade cidade) {

        cidade.setHabilitado(Boolean.TRUE); // habilita o produto por padrão
        return repository.save(cidade); // insere no banco de dados
    }

    public List<Cidade> listarTodos() {
            return repository.findAll(); // select * from produto
        }

        public Cidade obterPorID(Long id) {
            return repository.findById(id).get(); // select * from produto where id = ?
        }

        @Transactional
        public void update(Long id, Cidade cidadeAlterada) {

        Cidade cidade = repository.findById(id).get();
        cidade.setNome(cidadeAlterada.getNome());
        cidade.setEstado(cidadeAlterada.getEstado());
        cidade.setQtdPopulacao(cidadeAlterada.getQtdPopulacao());
        cidade.setEhCapital(cidadeAlterada.isEhCapital());
        cidade.setDataFundacao(cidadeAlterada.getDataFundacao());

        repository.save(cidade);
    }

        @Transactional
        public void delete(Long id) {

            Cidade cidade = repository.findById(id).get();
            cidade.setHabilitado(Boolean.FALSE);

            repository.save(cidade);
    }
}
