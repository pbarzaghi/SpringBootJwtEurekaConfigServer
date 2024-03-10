package ar.programa.proyectointegrador.dto;


import lombok.*;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDto {

    private String razonSocial;
    private String cuit;
    private String mail;

}
