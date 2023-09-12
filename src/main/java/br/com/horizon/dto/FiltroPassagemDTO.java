package br.com.horizon.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FiltroPassagemDTO {

    private String aeroportoDestino = "";
    private String aeroportoOrigem = "";
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dataPesquisa;
    private Double valorVoo;
}
