package br.com.ifpe.oxefood.modelo.empresa;

import java.util.List;

import org.hibernate.annotations.SQLRestriction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.ifpe.oxefood.modelo.entregador.Entregador;
import br.com.ifpe.oxefood.util.entity.EntidadeAuditavel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Empresa")
@SQLRestriction("habilitado = true")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Empresa extends EntidadeAuditavel{

    @OneToMany(mappedBy = "empresa", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Entregador> entregadores;

    @Column
    private String site;

    @Column
    private String cnpj;

    @Column
    private String inscricaoEstadual;

    @Column
    private String nomeEmpresarial;

    @Column
    private String nomeFantasia;

    @Column
    private String fone;

    @Column
    private String foneAlternativo;
}
