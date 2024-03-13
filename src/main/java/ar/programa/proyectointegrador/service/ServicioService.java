package ar.programa.proyectointegrador.service;


import ar.programa.proyectointegrador.dto.ServicioDto;

/*
 @author pabloBarzaghi
 */
public interface ServicioService extends CrudService<ServicioDto,Integer> {
    public ServicioDto addDetalleIncidencia(Integer idServicio, Integer idDetalleIncidencia) ;

}
