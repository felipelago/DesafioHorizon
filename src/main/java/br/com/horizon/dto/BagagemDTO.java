package br.com.horizon.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BagagemDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private Boolean despachado = false;


}
