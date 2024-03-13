package ar.programa.proyectointegrador.dto;


import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DetalleIncidenciaDto {

    private Integer id;
    private String detalleProblema;

    private String descripcionProblema;

    private Boolean resuelto;


}
