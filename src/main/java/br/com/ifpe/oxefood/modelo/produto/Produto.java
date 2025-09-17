package br.com.ifpe.oxefood.modelo.produto;

import br.com.ifpe.oxefood.util.entity.EntidadeAuditavel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.hibernate.annotations.SQLRestriction;

@Entity
@Table(name = "Cliente")
@SQLRestriction("habilitado = true")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Produto extends EntidadeAuditavel  {
  
   @Column
   private String codigo;

   @Column
   private String titulo;

   @Column
   private String descricao;

   @Column
   private double valorUnitario;

   @Column
   private int tempoEntregaMinimo;

   @Column
   private int tempoEntregaMaximo;

}
