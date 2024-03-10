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
@Table(name="especialidad")
/**
 @author pabloBarzaghi
 */
public class Especialidad   implements Serializable {


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @JsonManagedReference
    @ManyToMany(mappedBy = "especialidades")
    List<TipoProblema> tipoProblemas;

    @JsonManagedReference
    @ManyToMany(mappedBy = "especialidades")
    List<Tecnico> tecnicos;

}
