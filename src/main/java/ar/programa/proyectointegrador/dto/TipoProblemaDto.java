package ar.programa.proyectointegrador.dto;


import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class TipoProblemaDto {

    private String tipo;
    private Integer tiempoEnDias;

}
