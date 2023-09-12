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
public class Aeroporto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_aeroporto")
    private Long id;

    @NotEmpty(message = "Nome {field.not.blank}")
    @Size(min = 2, max = 150, message = "{field.size}")
    @Column(name = "nome", length = 150, nullable = false)
    private String nome;

    @NotEmpty(message = "Codigo Iata {field.not.blank}")
    @Size(min = 3, max = 3, message = "{field.size}")
    @Column(name = "codigo_iata", length = 3, nullable = false, unique = true)
    private String codigoIata;
    @JoinColumn(name = "id_cidade")
    @ManyToOne(optional = false)
    private Cidade cidade;

}
