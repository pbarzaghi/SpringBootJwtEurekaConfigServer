package ar.programa.proyectointegrador.service;


import ar.programa.proyectointegrador.dto.ServicioDto;
import ar.programa.proyectointegrador.entity.DetalleIncidencia;
import ar.programa.proyectointegrador.entity.Servicio;
import ar.programa.proyectointegrador.mapper.MapperEntity;
import ar.programa.proyectointegrador.repository.IncidenciaDetalleRepository;
import ar.programa.proyectointegrador.repository.ServicioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
/*
 @author pabloBarzaghi
 */
@Service
@RequiredArgsConstructor
public class ServicioServiceImpl implements ServicioService {

    private final ServicioRepository servicioRepository;
    private final IncidenciaDetalleRepository incidenciaDetalleRepository;
    @Override
    public ResponseEntity<?> findAll()  {
        return   ResponseEntity.ok(MapperEntity.mapper.toDtoListServicio(
                servicioRepository.findAll()));
    }

    @Override
    public ServicioDto save(ServicioDto servicioDto)
    {
        return   MapperEntity.mapper.toDto(
                servicioRepository.save( MapperEntity.mapper.toBean(servicioDto))
                                           );
    }

    @Override
    public ServicioDto update(ServicioDto servicioDto)  {

        return   MapperEntity.mapper.toDto(
                servicioRepository.save( MapperEntity.mapper.toBean(servicioDto))
        );
    }

    @Override
    public Optional<ServicioDto> findById(Integer integer)  {

         Servicio servicio = servicioRepository.findById(integer).orElse(null);

         if ( servicio == null)
             return Optional.ofNullable(ServicioDto.builder().build());
       else
            return Optional.ofNullable(MapperEntity.mapper.toDto(servicio));
    }

    @Override
    public void deleteById(Integer integer)  {
        servicioRepository.deleteById(integer);
    }

    @Override
    public void deleteAll()  {
        servicioRepository.deleteAll();
    }

    @Override
    public ServicioDto addDetalleIncidencia(Integer idServicio, Integer idDetalleIncidencia) {

        Servicio servicio= servicioRepository.findById(idServicio).orElse(null);

        if(servicio!=null){
            //TODO: Utilizar cuando se realice un ApiGateway un restTemplate
            DetalleIncidencia detalleIncidencia=incidenciaDetalleRepository.findById(idDetalleIncidencia).orElse(null);

            List<DetalleIncidencia> detalleIncidenciaList=servicio.getDetallesincidencias();
            if( detalleIncidencia!=null && (! detalleIncidenciaList.contains(detalleIncidencia))) {
                detalleIncidenciaList.add(detalleIncidencia);
                servicio.setDetallesincidencias(detalleIncidenciaList);
                detalleIncidencia.setServicio(servicio);
                incidenciaDetalleRepository.save(detalleIncidencia);
                return MapperEntity.mapper.toDto(servicioRepository.save(servicio));
            }
        }
        return null;
    }
}
