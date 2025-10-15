package br.com.ifpe.oxefood.api.produto;

import org.hibernate.validator.constraints.Length;

import br.com.ifpe.oxefood.modelo.produto.Produto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoRequest {

    @NotNull(message = "O idCategoria é de preenchimento obrigatório")
    private Long idCategoria;

    @NotBlank(message = "O código é de preenchimento obrigatório")
    private String codigo;

    @NotBlank(message = "O título é de preenchimento obrigatório")
    @Length(max = 100, message = "O título deverá ter no máximo {max} caracteres")
    private String titulo;

    @NotBlank(message = "A descrição é de preenchimento obrigatório")
    private String descricao;

    @NotBlank(message = "O valor unitário é de preenchimento obrigatório")
    private double valorUnitario;

    @NotBlank(message = "O tempo de entrega mínimo é de preenchimento obrigatório")
    private int tempoEntregaMinimo;

    @NotBlank(message = "O tempo de entrega máximo é de preenchimento obrigatório")
    private int tempoEntregaMaximo;

    public Produto build() {

        return Produto.builder() // instanciando um objeto da classe Produto
                .codigo(codigo)
                .titulo(titulo)
                .descricao(descricao)
                .valorUnitario(valorUnitario)
                .tempoEntregaMinimo(tempoEntregaMinimo)
                .tempoEntregaMaximo(tempoEntregaMaximo)
                .build();
    }
}
