package br.com.horizon.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CidadeDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    @NotEmpty(message = "Nome {field.not.blank}")
    @Size(min = 2, max = 80, message = "{field.size}")
    private String nome;

    @NotEmpty(message = "uf {field.not.blank}")
    @Size(min = 2, max = 2, message = "{field.size}")
    private String uf;

}
