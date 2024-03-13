package ar.programa.proyectointegrador.service;


import ar.programa.proyectointegrador.dto.TecnicoDto;
import java.util.List;

/*
 @author pabloBarzaghi
 */
public interface TecnicoService extends CrudService<TecnicoDto,Integer> {

      public TecnicoDto addIncidencia(Integer idTecnico, Integer idIncidencia  );
      public TecnicoDto addEspecialidad(Integer idTecnico,Integer idEspecialidad);

      List<TecnicoDto> findTecnicosConMasIncidentesResueltosEnNDias(Integer dias);
      List<TecnicoDto> findTecnicosConMasIncidentesResueltosEnNDiasEspecialidad(Integer dias,Integer idEsp);

      List<TecnicoDto> findTecnicoMasRapidoResolvioLaIncidencia() ;

}
