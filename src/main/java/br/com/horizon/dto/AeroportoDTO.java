package br.com.horizon.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AeroportoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    @NotEmpty(message = "Nome {field.not.blank}")
    @Size(min = 2, max = 150, message = "{field.size}")
    private String nome;

    @NotEmpty(message = "Codigo Iata {field.not.blank}")
    @Size(min = 3, max = 3, message = "{field.size}")
    private String codigoIata;

    private CidadeDTO cidade;

}
