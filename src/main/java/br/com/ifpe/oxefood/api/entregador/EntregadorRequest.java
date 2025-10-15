package br.com.ifpe.oxefood.api.entregador;

import java.time.LocalDate;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.ifpe.oxefood.modelo.entregador.Entregador;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EntregadorRequest {

    @NotNull(message = "O nome é de preenchimento obrigatório")
    @NotEmpty(message = "O nome é de preenchimento obrigatório")
    @Length(max = 100, message = "O nome deverá ter no máximo {max} caracteres")
    private String nome;

    @NotBlank(message = "O CPF é de preenchimento obrigatório")
    @CPF
    private String cpf;

    @NotBlank(message = "O RG é de preenchimento obrigatório")
    private String rg;

    @NotBlank(message = "A data de nascimento é de preenchimento obrigatório")
    @Past(message = "A data de nascimento deve ser uma data passada")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    @Length(min = 8, max = 20, message = "O campo telefone tem que ter entre {min} e {max} caracteres")
    private String foneCelular;

    @Length(min = 8, max = 20, message = "O campo telefone fixo tem que ter entre {min} e {max} caracteres")
    private String foneFixo;

    @NotBlank(message = "A quantidade de entregas realizadas é de preenchimento obrigatório")
    private int qtdEntregasRealizadas;

    @NotBlank(message = "O valor do frete é de preenchimento obrigatório")
    private double valorFrete;

    @NotBlank(message = "A rua é de preenchimento obrigatório")
    private String enderecoRua;

    private String enderecoComplemento;

    @NotBlank(message = "O número é de preenchimento obrigatório")
    private String enderecoNumero;

    @NotBlank(message = "O bairro é de preenchimento obrigatório")
    private String enderecoBairro;

    @NotBlank(message = "A cidade é de preenchimento obrigatório")
    private String enderecoCidade;

    @NotBlank(message = "O CEP é de preenchimento obrigatório")
    private String enderecoCep;

    @NotBlank(message = "O UF é de preenchimento obrigatório")
    private String enderecoUf;

    @NotBlank(message = "O status de atividade é de preenchimento obrigatório")
    private boolean ativo;

    public Entregador build() {
        return Entregador.builder()
                .nome(nome)
                .cpf(cpf)
                .rg(rg)
                .dataNascimento(dataNascimento)
                .foneCelular(foneCelular)
                .foneFixo(foneFixo)
                .qtdEntregasRealizadas(qtdEntregasRealizadas)
                .valorFrete(valorFrete)
                .enderecoRua(enderecoRua)
                .enderecoComplemento(enderecoComplemento)
                .enderecoNumero(enderecoNumero)
                .enderecoBairro(enderecoBairro)
                .enderecoCidade(enderecoCidade)
                .enderecoCep(enderecoCep)
                .enderecoUf(enderecoUf)
                .ativo(ativo)
                .build();
    }

}
