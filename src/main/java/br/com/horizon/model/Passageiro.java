package br.com.horizon.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Passageiro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_passageiro")
    private Long id;

    @NotEmpty(message = "Nome {field.not.blank}")
    @Size(min = 2, max = 100, message = "{field.size}")
    @Column(name = "nome", length = 100, nullable = false)
    private String nome;

    @NotEmpty(message = "Cpf {field.not.blank}")
    @Size(min = 11, max = 11, message = "{field.size}")
    @Column(name = "cpf", length = 11, nullable = false)
    private String cpf;

    @NotEmpty(message = "Email {field.not.blank}")
    @Size(min = 5, max = 50, message = "{field.size}")
    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "data_nascimento", nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    @Past(message = "{field.not.dateOfBirth}")
    private Date dataNascimento;

}
