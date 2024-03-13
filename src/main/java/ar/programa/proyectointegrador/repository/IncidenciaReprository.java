package ar.programa.proyectointegrador.repository;

import ar.programa.proyectointegrador.entity.Incidencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 @author pabloBarzaghi
 */
@Repository
public interface IncidenciaReprository extends JpaRepository<Incidencia,Integer> {

    List<Incidencia> findAllByTecnico_Id(Integer tecnicoId);
    List<Incidencia> findAllByTipoProblema_Id(Integer problemaId);

    List<Incidencia> findAllByCliente_Id(Integer clienteId);


}
