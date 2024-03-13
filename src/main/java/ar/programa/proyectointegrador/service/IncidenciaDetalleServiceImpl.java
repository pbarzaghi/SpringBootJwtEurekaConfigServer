package ar.programa.proyectointegrador.service;


import ar.programa.proyectointegrador.dto.DetalleIncidenciaDto;
import ar.programa.proyectointegrador.dto.IncidenciaDto;
import ar.programa.proyectointegrador.entity.DetalleIncidencia;
import ar.programa.proyectointegrador.mapper.MapperEntity;
import ar.programa.proyectointegrador.repository.IncidenciaDetalleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
/*
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
    public DetalleIncidenciaDto save(DetalleIncidenciaDto detalleIncidenciaDto)  {

        return MapperEntity.mapper.toDto(
                incidenciaDetalleRepository.save(MapperEntity.mapper.toBean(detalleIncidenciaDto))
                                         );
    }

    @Override
    public DetalleIncidenciaDto update(DetalleIncidenciaDto detalleIncidenciaDto) {
        return MapperEntity.mapper.toDto(
                incidenciaDetalleRepository.save(MapperEntity.mapper.toBean(detalleIncidenciaDto))
        );
    }
    @Override
    public Optional<DetalleIncidenciaDto> findById(Integer integer)  {

        DetalleIncidencia detalleIncidencia= incidenciaDetalleRepository.findById(integer).orElse(null);

        if ( detalleIncidencia == null)
            return Optional.ofNullable(DetalleIncidenciaDto.builder().build());
        else
            return Optional.ofNullable(MapperEntity.mapper.toDto(detalleIncidencia));
    }


    @Override
    public void deleteById(Integer integer)  {
        incidenciaDetalleRepository.deleteById(integer);
    }

    @Override
    public void deleteAll()  {
        incidenciaDetalleRepository.deleteAll();
    }


    @Override
    public DetalleIncidenciaDto save(IncidenciaDto incidenciaDto, DetalleIncidenciaDto detalleIncidenciaDto) {

        DetalleIncidencia detalleIncidencia = MapperEntity.mapper.toBean(detalleIncidenciaDto);
        detalleIncidencia.setIncidencia(MapperEntity.mapper.toBean(incidenciaDto));
        return MapperEntity.mapper.toDto( incidenciaDetalleRepository.save(detalleIncidencia));
    }
}
