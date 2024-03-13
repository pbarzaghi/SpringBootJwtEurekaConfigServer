package ar.programa.proyectointegrador.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDto {
    private Integer id;
    private String nombreUsuario;
    private String pass;
    private Integer tipousuario;



}
