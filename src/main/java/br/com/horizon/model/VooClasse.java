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
@Table(name = "voo_classe")
public class VooClasse implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_voo_classe")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_voo")
    private Voo voo;

    @ManyToOne
    @JoinColumn(name = "id_classe")
    private Classe classe;


}
