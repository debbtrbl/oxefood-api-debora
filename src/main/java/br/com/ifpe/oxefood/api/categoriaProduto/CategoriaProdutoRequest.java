package br.com.ifpe.oxefood.api.categoriaProduto;


import br.com.ifpe.oxefood.modelo.categoriaProduto.CategoriaProduto;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaProdutoRequest {

   @NotBlank(message = "A descrição é obrigatória")
   private String descricao;
   
   
   public CategoriaProduto build() {

       return CategoriaProduto.builder() //instanciando um objeto da classe CategoriaProduto
           .descricao(descricao)
           .build();
   }

}
