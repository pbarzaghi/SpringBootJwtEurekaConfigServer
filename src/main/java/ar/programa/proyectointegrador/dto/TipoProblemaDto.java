package ar.programa.proyectointegrador.dto;

import jakarta.persistence.Column;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class TipoProblemaDto {

    private String tipo;
    private Integer tiempoEnDias;

}
