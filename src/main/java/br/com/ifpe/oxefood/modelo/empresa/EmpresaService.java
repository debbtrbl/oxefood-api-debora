package br.com.ifpe.oxefood.modelo.empresa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class EmpresaService {
    @Autowired
   private EmpresaRepository repository; 

   @Transactional
   public Empresa save(Empresa empresa) {

       empresa.setHabilitado(Boolean.TRUE); // habilita a empresa por padrão
       return repository.save(empresa); // insere no banco de dados
   }

   public List<Empresa> listarTodos() {
        return repository.findAll(); // select * from empresa
    }

    public Empresa obterPorID(Long id) {
        return repository.findById(id).get(); // select * from empresa where id = ?
    }

     @Transactional
    public void update(Long id, Empresa empresaAlterada) {

      Empresa empresa = repository.findById(id).get();
      empresa.setSite(empresaAlterada.getSite());
      empresa.setCnpj(empresaAlterada.getCnpj());
      empresa.setInscricaoEstadual(empresaAlterada.getInscricaoEstadual());
      empresa.setNomeEmpresarial(empresaAlterada.getNomeEmpresarial());
      empresa.setNomeFantasia(empresaAlterada.getNomeFantasia());
      empresa.setFone(empresaAlterada.getFone());
      empresa.setFoneAlternativo(empresaAlterada.getFoneAlternativo());
      repository.save(empresa);
  }

    @Transactional
    public void delete(Long id) {

        Empresa empresa = repository.findById(id).get();
        empresa.setHabilitado(Boolean.FALSE);

        repository.save(empresa);
   }

}
