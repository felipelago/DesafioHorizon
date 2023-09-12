package br.com.horizon.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Passagem implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_passagem")
    private Long id;

    @JoinColumn(name = "id_passageiro")
    @ManyToOne(optional = false)
    private Passageiro passageiro;

    @Column(name = "valor_total", nullable = false)
    private Double valorTotal;

    @JoinColumn(name = "id_classe")
    @ManyToOne(optional = false)
    private Classe classe;

    @JoinColumn(name = "id_bagagem")
    @ManyToOne(cascade = CascadeType.ALL)
    private Bagagem bagagem;

    @JoinColumn(name = "id_voo")
    @ManyToOne(optional = false)
    private Voo voo;

}
