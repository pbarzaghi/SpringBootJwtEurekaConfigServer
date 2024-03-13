package ar.programa.proyectointegrador.service;


import ar.programa.proyectointegrador.dto.TecnicoDto;
import ar.programa.proyectointegrador.entity.Especialidad;
import ar.programa.proyectointegrador.entity.Incidencia;
import ar.programa.proyectointegrador.entity.Tecnico;
import ar.programa.proyectointegrador.mapper.MapperEntity;
import ar.programa.proyectointegrador.repository.TecnicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
/*
 @author pabloBarzaghi
 */
@Service
@RequiredArgsConstructor
public class TecnicoServiceImpl implements TecnicoService{

    private final TecnicoRepository tecnicoRepository;
    private final IncidenciaService incidenciaService;
    private final EspecialidadService especialidadService;
   // @PersistenceContext
   // EntityManager entityManager;

    @Transactional(readOnly = true)
    @Override
    public ResponseEntity<?> findAll() {
        return   ResponseEntity.ok(MapperEntity.mapper.toDtoListTecnico(
                tecnicoRepository.findAll()));
    }
    @Transactional
    @Override
    public TecnicoDto save(TecnicoDto tecnicoDto) {

         return MapperEntity.mapper.toDto(
                tecnicoRepository.save(  MapperEntity.mapper.toBean(tecnicoDto))
                            );

    }

    @Transactional
     @Override
    public TecnicoDto update(TecnicoDto tecnicoDto)  {
        return MapperEntity.mapper.toDto(
                tecnicoRepository.save(  MapperEntity.mapper.toBean(tecnicoDto))
        );
    }

    @Transactional
    @Override
    public Optional<TecnicoDto> findById(Integer integer)  {
        Tecnico tecnico=tecnicoRepository.findById(integer).orElse(null);
        if ( tecnico == null)
            return Optional.ofNullable(TecnicoDto.builder().build());
        else
            return Optional.ofNullable(MapperEntity.mapper.toDto(tecnico));
    }

    @Transactional
    @Override
    public void deleteById(Integer idTecnico)  {

        incidenciaService.deleteAllTecnico(idTecnico);
        tecnicoRepository.deleteById(idTecnico);
    }

    @Override
    public void deleteAll() {
        tecnicoRepository.deleteAll();
    }
@Transactional
    @Override
    public TecnicoDto addIncidencia(Integer idTecnico , Integer idIncidencia ) {

        Tecnico tecnico=tecnicoRepository.findById(idTecnico).orElse(null);

         if(tecnico != null) {
             //TODO: llamar a restTemp
             Incidencia incidencia=MapperEntity.mapper.toBean(incidenciaService.findById(idIncidencia).get());
            List<Incidencia> listIncidencias = tecnico.getIncidencias();
            if ( !listIncidencias.contains(incidencia)){
                listIncidencias.add(incidencia);
                tecnico.setIncidencias(listIncidencias);
                //TODO: llamar a restTemp
                incidenciaService.updateTecnico(idIncidencia,
                                              MapperEntity.mapper.toDto(tecnico)
                                       );



                return MapperEntity.mapper.toDto(tecnicoRepository.save(tecnico));
            }
        }
        return null;
    }
    @Transactional
    @Override
    public TecnicoDto addEspecialidad(Integer idTecnico, Integer IdEspecialidad) {
        Tecnico tecnico=tecnicoRepository.findById(idTecnico).orElse(null);
           if (tecnico != null) {
               //TODO: llamar a restTemp
               Especialidad especialidad =MapperEntity.mapper.toBean(especialidadService.findById(IdEspecialidad).get());
               List<Especialidad> listEspecialidades=tecnico.getEspecialidades();
            if(especialidad != null &&         ( !listEspecialidades.contains(especialidad))) {
                listEspecialidades.add(especialidad);
                tecnico.setEspecialidades(listEspecialidades);
                return MapperEntity.mapper.toDto(tecnicoRepository.save(tecnico));
            }

        }

     return null;
    }
    @Transactional
    @Override
    public List<TecnicoDto> findTecnicosConMasIncidentesResueltosEnNDias(Integer dias) {
        // Calcular las fechas
        LocalDateTime fechaFin = LocalDateTime.now();
        LocalDateTime fechaInicio = fechaFin.minusDays(dias);

        return  MapperEntity.mapper.toDtoListTecnico(
                tecnicoRepository.findAllTecnicosByIncidenciaResueltaEntreFechas(fechaInicio,fechaFin)
        );


    }

    @Transactional
    @Override
    public List<TecnicoDto> findTecnicosConMasIncidentesResueltosEnNDiasEspecialidad(Integer dias,
                                                                                      Integer idEsp) {

        // Calcular las fechas
        LocalDateTime fechaFin = LocalDateTime.now();
        LocalDateTime fechaInicio = fechaFin.minusDays(dias);
        return   MapperEntity.mapper.toDtoListTecnico(
                tecnicoRepository.findAllTecnicosByIncidenciaResueltaEntreFechasEspecialidad(fechaInicio, fechaFin, idEsp)
                );

    }

    @Override
    public List<TecnicoDto> findTecnicoMasRapidoResolvioLaIncidencia() {
        return  MapperEntity.mapper.toDtoListTecnico(
                tecnicoRepository.findTecnicoMasRapidoResolvioLaIncidencia()
        );
    }

}
