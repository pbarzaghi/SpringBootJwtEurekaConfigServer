package ar.programa.proyectointegrador.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name="tecnico")
/*
 @author pabloBarzaghi
 */
public class Tecnico implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(name="nombre")
    private String nombre;
    @Column(name="mail")
    private String mail;
    @Column(name="numTelefono")
    private String nroTel;

    @JsonManagedReference
    @OneToMany
    List<Incidencia> incidencias;
    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY )

    @JoinTable(
            name = "tecnico_especialidad",
            joinColumns = @JoinColumn(name = "tecnico_id"),
            inverseJoinColumns = @JoinColumn(name = "especialidad_id")
       )
    @OnDelete(action = OnDeleteAction.CASCADE)
    List<Especialidad> especialidades;



}
