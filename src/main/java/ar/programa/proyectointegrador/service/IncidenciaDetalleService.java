package ar.programa.proyectointegrador.service;

import ar.programa.proyectointegrador.dto.DetalleIncidenciaDto;
import ar.programa.proyectointegrador.dto.IncidenciaDto;

/*
 @author pabloBarzaghi
 */
public interface IncidenciaDetalleService extends CrudService<DetalleIncidenciaDto,Integer> {

    DetalleIncidenciaDto save(IncidenciaDto incidenciaDto, DetalleIncidenciaDto detalleIncidenciaDto);




}
