package ar.programa.proyectointegrador.service;

import ar.programa.proyectointegrador.entity.Especialidad;
import ar.programa.proyectointegrador.entity.Incidencia;
import ar.programa.proyectointegrador.entity.TipoProblema;
import ar.programa.proyectointegrador.mapper.MapperEntity;
import ar.programa.proyectointegrador.repository.TipoProblemaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
/**
 @author pabloBarzaghi
 */
@Service
@RequiredArgsConstructor
public class TipoProblemaServiceImpl implements TipoProblemaService{
   private final  TipoProblemaRepository tipoProblemaRepository;
    @Override
    public ResponseEntity<?> findAll()  {
        return   ResponseEntity.ok(MapperEntity.mapper.toDtoListTipoProblema(
                tipoProblemaRepository.findAll()));
    }

    @Override
    public TipoProblema save(TipoProblema tipoProblema)  {
        return tipoProblemaRepository.save(tipoProblema);
    }

    @Override
    public TipoProblema update(TipoProblema tipoProblema)  {
        return tipoProblemaRepository.save(tipoProblema);
    }

    @Transactional
    @Override
    public Optional<TipoProblema> findById(Integer integer)  {
        return tipoProblemaRepository.findById(integer);
    }

    @Transactional
    @Override
    public void deleteById(Integer integer) {
        tipoProblemaRepository.deleteById(integer);
    }

    @Transactional
    @Override
    public void deleteAll()  {
        tipoProblemaRepository.deleteAll();
    }

   @Transactional
    @Override
    public TipoProblema addEspecialidad(TipoProblema tipoProblema, Especialidad especialidad) {
       List<Especialidad> especialidadList=tipoProblema.getEspecialidades();
       if(!especialidadList.contains(especialidad)) {
           especialidadList.add(especialidad);
           tipoProblema.setEspecialidades(especialidadList);

           return tipoProblemaRepository.save(tipoProblema);
       }
       return null;
    }
    @Transactional
    @Override
    public TipoProblema addIncidencia(TipoProblema tipoProblema, Incidencia incidencia) {
        List<Incidencia> incidenciaList=tipoProblema.getIncidencias();
        if(!incidenciaList.contains(incidencia)) {
            incidenciaList.add(incidencia);
            tipoProblema.setIncidencias(incidenciaList);
            incidencia.setTipoProblema(tipoProblema);
            return tipoProblemaRepository.save(tipoProblema);
        }
        return null;
    }
}
