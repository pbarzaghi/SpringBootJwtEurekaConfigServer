package ar.programa.proyectointegrador.entity;

import ar.programa.proyectointegrador.enumerado.TipoUsuarioEmun;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table (name="usuario")
/**
 @author pabloBarzaghi
 */

public class Usuario  implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;


    @Column(name="username")
    private String nombreUsuario;

    @Column(name="password")
    private String pass;

   // @ManyToOne
    //@JoinColumn(name = "tipousuario_id",referencedColumnName = "id" ,nullable=false)
    private TipoUsuario tipousuario_id;


}
