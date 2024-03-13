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
@Table(name="cliente")

/*
 @author pabloBarzaghi
 */
public class Cliente  implements Serializable{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
     private Integer id;


    private String razonSocial;

    @Column(name="CUIT")
    private String cuit;

    private String mail;


    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(
            name = "cliente_servicio",
            joinColumns = @JoinColumn(name = "cliente_id"),
            inverseJoinColumns = @JoinColumn(name = "servicio_id"))
    List<Servicio> servicios;


    @OneToMany(mappedBy = "cliente" )
     List<Incidencia> incidencias;





}
