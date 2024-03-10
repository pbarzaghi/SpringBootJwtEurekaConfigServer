package ar.programa.proyectointegrador.service;

import ar.programa.proyectointegrador.entity.DetalleIncidencia;
import ar.programa.proyectointegrador.entity.Servicio;
import ar.programa.proyectointegrador.mapper.MapperEntity;
import ar.programa.proyectointegrador.repository.ServicioRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
/**
 @author pabloBarzaghi
 */
@Service
@RequiredArgsConstructor
public class ServicioServiceImpl implements ServicioService {

    private final ServicioRepository servicioRepository;
    @Override
    public ResponseEntity<?> findAll()  {
        return   ResponseEntity.ok(MapperEntity.mapper.toDtoListServicio(
                servicioRepository.findAll()));
    }

    @Override
    public Servicio save(Servicio servicio)  {
        return servicioRepository.save(servicio);
    }

    @Override
    public Servicio update(Servicio servicio)  {
        return servicioRepository.save(servicio);
    }

    @Override
    public Optional<Servicio> findById(Integer integer)  {
        return servicioRepository.findById(integer);
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
    public Servicio addDetalleIncidencia(Servicio servicio, DetalleIncidencia detalleIncidencia) {
        List<DetalleIncidencia> detalleIncidenciaList=servicio.getDetalleincidencia();

        if(! detalleIncidenciaList.contains(detalleIncidencia)) {
            detalleIncidenciaList.add(detalleIncidencia);
            servicio.setDetalleincidencia(detalleIncidenciaList);
            detalleIncidencia.setServicio(servicio);
            return servicioRepository.save(servicio);
        }
        return null;
    }
}
