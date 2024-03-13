package ar.programa.proyectointegrador.dto;

import lombok.*;

import java.time.LocalDateTime;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class IncidenciaDto {
    private Integer id;
    private String alias;
    private String descripcion;
    private LocalDateTime fechaEstimada;
    private Boolean resuelto;


}