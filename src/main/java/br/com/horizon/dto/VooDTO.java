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
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VooDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    @NotEmpty(message = "Descricao {field.not.blank}")
    @Size(min = 2, max = 150, message = "{field.size}")
    private String descricao;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dataPartida;

    private AeroportoDTO aeroportoDestino;

    private AeroportoDTO aeroportoOrigem;

    private List<ClasseDTO> classes;
    private Integer qtdPassageiros;
    private List<PassagemVooDTO> passagens;
    private Double valorVoo;
    public Integer getQtdPassageiros() {
        return qtdPassageiros = passagens == null ? 0 : passagens.size();
    }
}
