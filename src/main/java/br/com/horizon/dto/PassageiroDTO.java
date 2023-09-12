package br.com.horizon.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PassageiroDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;

    @NotEmpty(message = "Nome {field.not.blank}")
    @Size(min = 2, max = 100, message = "{field.size}")
    private String nome;

    @NotEmpty(message = "Cpf {field.not.blank}")
    @Size(min = 11, max = 11, message = "{field.size}")
    private String cpf;

    @NotEmpty(message = "Email {field.not.blank}")
    @Size(min = 5, max = 50, message = "{field.size}")
    private String email;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Past(message = "{field.not.invalideDate}")
    private Date dataNascimento;

}
