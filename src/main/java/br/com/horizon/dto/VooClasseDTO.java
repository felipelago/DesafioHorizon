package br.com.horizon.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Table;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "voo_classe")
public class VooClasseDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private VooDTO voo;

    private ClasseDTO classe;

}
