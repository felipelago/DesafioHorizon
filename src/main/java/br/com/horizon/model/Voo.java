package br.com.horizon.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Voo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_voo")
    private Long id;

    @NotEmpty(message = "Descricao {field.not.blank}")
    @Size(min = 2, max = 150, message = "{field.size}")
    @Column(name = "descricao", length = 150, nullable = false)
    private String descricao;

    @Column(nullable = false, updatable = false)
    private LocalDateTime dataPartida;

    @JoinColumn(name = "id_aeroporto_destino")
    @ManyToOne(optional = false)
    private Aeroporto aeroportoDestino;

    @JoinColumn(name = "id_aeroporto_origem")
    @ManyToOne(optional = false)
    private Aeroporto aeroportoOrigem;

    @ManyToMany
    @JoinTable(name = "voo_classe", uniqueConstraints = @UniqueConstraint(columnNames = { "id_voo",
            "id_classe" }), joinColumns = {
            @JoinColumn(name = "id_voo") }, inverseJoinColumns = { @JoinColumn(name = "id_classe") })
    private List<Classe> classes;

    @Column(name = "cancelado")
    private Boolean cancelado = false;


    @OneToMany(mappedBy = "voo")
    private List<Passagem> passagens;

    @Column(name = "valor_voo", nullable = false)
    private Double valorVoo;

}
