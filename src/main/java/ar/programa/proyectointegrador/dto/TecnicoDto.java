package ar.programa.proyectointegrador.dto;

import jakarta.persistence.Column;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class TecnicoDto {

    private String nombre;
    private String mail;
    private String nroTel;



}
