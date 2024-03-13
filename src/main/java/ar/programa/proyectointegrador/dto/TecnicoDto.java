package ar.programa.proyectointegrador.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class TecnicoDto {

    private Integer id;
    private String nombre;
    private String mail;
    private String nroTel;



}
