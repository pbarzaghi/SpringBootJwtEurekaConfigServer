package ar.programa.proyectointegrador.dto;


import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DetalleIncidenciaDto {

    private String detalleProblema;

    private String descripcionProblema;

    private Boolean resuelto;


}
