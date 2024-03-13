package ar.programa.proyectointegrador.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name="tipoproblema")
/*
 @author pabloBarzaghi
 */
public class TipoProblema  implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;


    @Column(name="tipo")
    private String tipo;
    @Column(name="tiempoEstimadoDias")
    private Integer tiempoEnDias;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "tipoproblema_especialidad",
            joinColumns = @JoinColumn(name = "tipoProblema_id"),
            inverseJoinColumns = @JoinColumn(name = "especialidad_id"))
     List<Especialidad> especialidades;


    @OneToMany
    List<Incidencia> incidencias;





}
