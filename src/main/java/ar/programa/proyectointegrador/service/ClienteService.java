package ar.programa.proyectointegrador.service;


import ar.programa.proyectointegrador.dto.ClienteDto;
import ar.programa.proyectointegrador.dto.IncidenciaDto;
import ar.programa.proyectointegrador.dto.ServicioDto;


/*
 @author pabloBarzaghi
 */
public interface ClienteService extends CrudService<ClienteDto,Integer> {
    public ClienteDto addIncidencia(Integer idCliente ,Integer idIncidencia  );
    public ClienteDto addServicio(Integer idCliente ,Integer idServicio  );
}
