package br.com.horizon.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cidade implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cidade")
    private Long id;

    @NotEmpty(message = "Nome {field.not.blank}")
    @Size(min = 2, max = 80, message = "{field.size}")
    @Column(name = "nome", length = 80, nullable = false)
    private String nome;

    @NotEmpty(message = "uf {field.not.blank}")
    @Size(min = 2, max = 2, message = "{field.size}")
    @Column(name = "uf", length = 2, nullable = false)
    private String uf;

}
