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
public class ClasseDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;

    @NotEmpty(message = "Nome {field.not.blank}")
    @Size(min = 2, max = 80, message = "{field.size}")
    private String nome;

    private Integer qtdAssento;

    private Double valor;
}
