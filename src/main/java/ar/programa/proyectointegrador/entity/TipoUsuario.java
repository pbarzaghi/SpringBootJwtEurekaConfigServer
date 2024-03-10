package ar.programa.proyectointegrador.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name="tipousuario")
/**
 @author pabloBarzaghi
 */
public class TipoUsuario  implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;


    @Column(name = "tipo")
    private String tipo;


}
