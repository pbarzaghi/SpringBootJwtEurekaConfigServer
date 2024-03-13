package ar.programa.proyectointegrador.service;

import ar.programa.proyectointegrador.dto.ClienteDto;
import ar.programa.proyectointegrador.dto.IncidenciaDto;
import ar.programa.proyectointegrador.dto.TecnicoDto;
import ar.programa.proyectointegrador.dto.TipoProblemaDto;


/*
 @author pabloBarzaghi
 */
public interface IncidenciaService extends CrudService<IncidenciaDto,Integer> {

    public IncidenciaDto addDetalleIncidencia(Integer idIncidencia,Integer idDetalleIncidencia) ;
    public void deleteAllTecnico(Integer idTecnico);
    public void updateTecnico(Integer idIncidencia,TecnicoDto tecnicoDto);
    public void updateCliente(Integer idIncidencia, ClienteDto clienteDto);
    public void deleteAllCliente(Integer idCliente);
    public void deleteAllTipoProblema(Integer idTipoProblema);
    public void updateTipoProblema(Integer idIncidencia, TipoProblemaDto tipoProblemaDto);


}
