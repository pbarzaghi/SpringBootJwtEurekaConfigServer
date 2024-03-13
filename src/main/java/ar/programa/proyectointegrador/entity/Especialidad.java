package ar.programa.proyectointegrador.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serializable;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="especialidad")
/*
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
    @OnDelete(action = OnDeleteAction.CASCADE) // Esta anotación es específica de Hibernate
    List<Tecnico> tecnicos;

}
