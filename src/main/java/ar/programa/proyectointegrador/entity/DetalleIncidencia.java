package ar.programa.proyectointegrador.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name="detalleincidencia")
/*
 @author pabloBarzaghi
 */
public class DetalleIncidencia implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "incidencia_id", referencedColumnName = "id")
    private Incidencia incidencia;


    @ManyToOne
    @JoinColumn(name="servicio_id",referencedColumnName="id")
    private Servicio servicio;



    @Column(name="detalleProblema")
    private String detalleProblema;

    @Column(name="descripcionProblema")

    private String descripcionProblema;
    @Column(name="resuelto")
    private Boolean resuelto;
}


