package ar.programa.proyectointegrador.service;

import ar.programa.proyectointegrador.entity.DetalleIncidencia;

import ar.programa.proyectointegrador.mapper.MapperEntity;
import ar.programa.proyectointegrador.repository.IncidenciaDetalleRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
/**
 @author pabloBarzaghi
 */
@Service
@RequiredArgsConstructor
public class IncidenciaDetalleServiceImpl implements IncidenciaDetalleService{

    private final IncidenciaDetalleRepository incidenciaDetalleRepository;
    @Override
    public ResponseEntity<?> findAll() {
        return   ResponseEntity.ok(MapperEntity.mapper.toDtoListDetalleIncidencia(
                incidenciaDetalleRepository.findAll()));
    }

    @Override
    public DetalleIncidencia save(DetalleIncidencia detalleIncidencia)  {
        return incidenciaDetalleRepository.save(detalleIncidencia);
    }

    @Override
    public DetalleIncidencia update(DetalleIncidencia detalleIncidencia) {
        return incidenciaDetalleRepository.save(detalleIncidencia);
    }

    @Override
    public Optional<DetalleIncidencia> findById(Integer integer)  {
        return incidenciaDetalleRepository.findById(integer);
    }

    @Override
    public void deleteById(Integer integer)  {
        incidenciaDetalleRepository.deleteById(integer);
    }

    @Override
    public void deleteAll()  {
        incidenciaDetalleRepository.deleteAll();
    }


}
