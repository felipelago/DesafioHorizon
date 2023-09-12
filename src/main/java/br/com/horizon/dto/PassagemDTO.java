package br.com.horizon.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(value = {"valorTotal"}, allowGetters = true)
public class PassagemDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private PassageiroDTO passageiro;

    private Double valorTotal;

    private ClasseDTO classe;

    private BagagemDTO bagagem;

    private VooPassagemDTO voo;

}
