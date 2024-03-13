package ar.programa.proyectointegrador.service;


import ar.programa.proyectointegrador.dto.ClienteDto;
import ar.programa.proyectointegrador.dto.TipoProblemaDto;
import ar.programa.proyectointegrador.entity.*;
import ar.programa.proyectointegrador.mapper.MapperEntity;
import ar.programa.proyectointegrador.repository.TipoProblemaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
/*
 @author pabloBarzaghi
 */
@Service
@RequiredArgsConstructor
public class TipoProblemaServiceImpl implements TipoProblemaService{
   private final  TipoProblemaRepository tipoProblemaRepository;
   private final EspecialidadService especialidadService;
   private final IncidenciaService incidenciaService;
    @Override
    public ResponseEntity<?> findAll()  {
        return   ResponseEntity.ok(MapperEntity.mapper.toDtoListTipoProblema(
                tipoProblemaRepository.findAll()));
    }

    @Override
    @Transactional
    public TipoProblemaDto save(TipoProblemaDto tipoProblemaDto)  {
        return MapperEntity.mapper.toDto(
                tipoProblemaRepository.save(  MapperEntity.mapper.toBean(tipoProblemaDto))
                      );
    }

    @Override
    @Transactional
    public TipoProblemaDto  update(TipoProblemaDto tipoProblemaDto) {
        return MapperEntity.mapper.toDto(
                tipoProblemaRepository.save(MapperEntity.mapper.toBean(tipoProblemaDto))
        );
    }

    @Override
    public Optional<TipoProblemaDto> findById(Integer integer)  {

        TipoProblema tipoProblema = tipoProblemaRepository.findById(integer).orElse(null);

        if ( tipoProblema == null)
            return Optional.ofNullable(TipoProblemaDto.builder().build());
        else
            return Optional.ofNullable(MapperEntity.mapper.toDto(tipoProblema));
    }

    @Transactional
    @Override
    public void deleteById(Integer idTipoProblema) {
        incidenciaService.deleteAllTipoProblema(idTipoProblema);
        tipoProblemaRepository.deleteById(idTipoProblema);
    }

    @Transactional
    @Override
    public void deleteAll()  {
        tipoProblemaRepository.deleteAll();
    }

   @Transactional
    @Override
    public TipoProblemaDto addEspecialidad(Integer idTipoProblema,Integer idEspecialidad) {

       TipoProblema tipoProblema=tipoProblemaRepository.findById(idTipoProblema).orElse(null);
       //TODO: usar RestTemplate

       if(tipoProblema!=null){
           Especialidad especialidad =MapperEntity.mapper.toBean(
                   especialidadService.findById(idEspecialidad).get());
        List<Especialidad> especialidadList=tipoProblema.getEspecialidades();
       if(!especialidadList.contains(especialidad)) {
           especialidadList.add(especialidad);
           tipoProblema.setEspecialidades(especialidadList);
           return MapperEntity.mapper.toDto(tipoProblemaRepository.save(tipoProblema));
       }
       }
       return null;
    }
    @Transactional
    @Override
    public TipoProblemaDto addIncidencia(Integer idTipoProblema,Integer idIncidencia) {

        TipoProblema tipoProblema=tipoProblemaRepository.findById(idTipoProblema).orElse(null);

        if(tipoProblema != null){
            //TODO: usar RestTemplate
            Incidencia incidencia =MapperEntity.mapper.toBean(
                    incidenciaService.findById(idIncidencia).get());
            List<Incidencia> incidenciaList=tipoProblema.getIncidencias();
            if(!incidenciaList.contains(incidencia)) {
                incidenciaList.add(incidencia);
                tipoProblema.setIncidencias(incidenciaList);
                incidenciaService.updateTipoProblema(idIncidencia,MapperEntity.mapper.toDto(tipoProblema));

                return MapperEntity.mapper.toDto(tipoProblemaRepository.save(tipoProblema));
            }
        }
        return null;
    }
}
