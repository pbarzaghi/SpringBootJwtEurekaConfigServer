package ar.programa.proyectointegrador.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="servicio")
/*
 @author pabloBarzaghi
 */
public class Servicio implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @JsonManagedReference
    @ManyToMany(mappedBy = "servicios")
    List<Cliente> clientes;

    @OneToMany
    List<DetalleIncidencia> detalleincidencia;


}
