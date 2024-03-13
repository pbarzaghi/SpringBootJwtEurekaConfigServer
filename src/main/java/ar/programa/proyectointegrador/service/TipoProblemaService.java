package ar.programa.proyectointegrador.service;


import ar.programa.proyectointegrador.dto.TipoProblemaDto;

/*
 @author pabloBarzaghi
 */
public interface TipoProblemaService extends CrudService<TipoProblemaDto,Integer>{
    public TipoProblemaDto addEspecialidad(Integer idTipoProblema, Integer idEspecialidad  );
    public TipoProblemaDto addIncidencia(Integer idTipoProblema, Integer idIncidencia  );
}
