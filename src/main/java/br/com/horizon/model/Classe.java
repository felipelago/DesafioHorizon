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
public class Classe implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_classe")
    private Long id;

    @NotEmpty(message = "Nome {field.not.blank}")
    @Size(min = 2, max = 80, message = "{field.size}")
    @Column(name = "nome", length = 80, nullable = false)
    private String nome;

    @Column(name = "qtd_assento", nullable = false)
    private Integer qtdAssento;

    @Column(name = "valor", nullable = false)
    private Double valor;
}
