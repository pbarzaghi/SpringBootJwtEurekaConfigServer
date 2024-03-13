package ar.programa.proyectointegrador.service;

import ar.programa.proyectointegrador.dto.EspecialidadDto;
import ar.programa.proyectointegrador.entity.Especialidad;
import ar.programa.proyectointegrador.mapper.MapperEntity;
import ar.programa.proyectointegrador.repository.EspecialidadRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
/*
 @author pabloBarzaghi
 */
@Service
@RequiredArgsConstructor
public class EspecialidadServiceImpl implements EspecialidadService {
     private final EspecialidadRepository especialidadRepository;
    @Transactional(readOnly = true)
    @Override
    public ResponseEntity<?> findAll() {
       return ResponseEntity.ok(MapperEntity.mapper.toDtoListEspecialidad(
                especialidadRepository.findAll()));
    }
    @Transactional
    @Override
    public EspecialidadDto save(EspecialidadDto especialidadDto)   {
        return  MapperEntity.mapper.toDto(
                especialidadRepository.save(MapperEntity.mapper.toBean(especialidadDto))
                );
    }
    @Transactional
    @Override
    public EspecialidadDto update(EspecialidadDto especialidadDto)   {
        return  MapperEntity.mapper.toDto(
                especialidadRepository.save(MapperEntity.mapper.toBean(especialidadDto))
        );
    }
    @Transactional
    @Override
    public Optional<EspecialidadDto> findById(Integer integer)  {

        Especialidad especialidad= especialidadRepository.findById(integer).orElse(null);
        if ( especialidad == null)
            return Optional.ofNullable(EspecialidadDto.builder().build());
        else
            return Optional.ofNullable(MapperEntity.mapper.toDto(especialidad));
    }


    @Transactional
    @Override
    public void deleteById(Integer integer)  {

        especialidadRepository.deleteById(integer);
    }
    @Transactional
    @Override
    public void deleteAll()  {
        especialidadRepository.deleteAll();
    }
}
