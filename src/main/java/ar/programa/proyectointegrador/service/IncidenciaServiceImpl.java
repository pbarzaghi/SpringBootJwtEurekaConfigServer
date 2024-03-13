package ar.programa.proyectointegrador.service;

import ar.programa.proyectointegrador.dto.ClienteDto;
import ar.programa.proyectointegrador.dto.IncidenciaDto;
import ar.programa.proyectointegrador.dto.TecnicoDto;
import ar.programa.proyectointegrador.dto.TipoProblemaDto;
import ar.programa.proyectointegrador.entity.DetalleIncidencia;
import ar.programa.proyectointegrador.entity.Incidencia;
import ar.programa.proyectointegrador.mapper.MapperEntity;
import ar.programa.proyectointegrador.repository.IncidenciaReprository;
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
public class IncidenciaServiceImpl implements IncidenciaService{

    private final IncidenciaReprository incidenciaReprository;
    private  final IncidenciaDetalleService incidenciaDetalleService;
    @Override
    public ResponseEntity<?> findAll()   {
        return   ResponseEntity.ok(MapperEntity.mapper.toDtoListIncidencia(
                incidenciaReprository.findAll()));
    }

    @Override
    @Transactional
    public IncidenciaDto save(IncidenciaDto incidenciaDto)  {
        return  MapperEntity.mapper.toDto(
                       incidenciaReprository.save(MapperEntity.mapper.toBean(incidenciaDto))
                                          );

    }

    @Override
    @Transactional
    public IncidenciaDto update(IncidenciaDto incidenciaDto)  {
        return  MapperEntity.mapper.toDto(
                incidenciaReprository.save(MapperEntity.mapper.toBean(incidenciaDto))
        );

    }
    @Override
    public Optional<IncidenciaDto> findById(Integer integer)  {
         Incidencia incidencia = incidenciaReprository.findById(integer).orElse(null);
        if ( incidencia == null)
            return Optional.ofNullable(IncidenciaDto.builder().build());
        else
            return Optional.ofNullable(MapperEntity.mapper.toDto(incidencia));
    }

    @Override
    @Transactional
    public void deleteById(Integer integer)  {
        incidenciaReprository.deleteById(integer);
    }


    @Transactional
    @Override
    public void deleteAll()  {
        incidenciaReprository.deleteAll();
    }

    @Transactional
    @Override
    public IncidenciaDto addDetalleIncidencia(Integer idIncidencia, Integer idDetalleIncidencia) {

        Incidencia incidencia=incidenciaReprository.findById(idIncidencia).orElse(null);
        if(incidencia !=null){
           DetalleIncidencia detalleIncidencia=MapperEntity.mapper.toBean(
                  incidenciaDetalleService.findById(idDetalleIncidencia).get()
                 );
        List<DetalleIncidencia> detalleIncidenciaList=incidencia.getDetallesincidencias();
        if(! detalleIncidenciaList.contains(detalleIncidencia)) {
            detalleIncidenciaList.add(detalleIncidencia);
            incidencia.setDetallesincidencias(detalleIncidenciaList);
            if( detalleIncidencia.getResuelto() == null)
                detalleIncidencia.setResuelto(Boolean.FALSE);
            incidencia.setResuelto(detalleIncidencia.getResuelto());

            incidenciaDetalleService.save( MapperEntity.mapper.toDto( incidencia),
                                           MapperEntity.mapper.toDto( detalleIncidencia));
            return MapperEntity.mapper.toDto(
                             incidenciaReprository.save(incidencia));
             }
        }
        return null;
    }
    @Transactional
     @Override
    public void deleteAllTecnico(Integer idTecnico) {

        List<Incidencia> incidencias=incidenciaReprository.findAllByTecnico_Id(idTecnico);
        incidencias.forEach(i ->{ i.setTecnico(null);
                    incidenciaReprository.save(i);
                }
        );
    }
    @Transactional
    @Override
    public void deleteAllTipoProblema(Integer idTipoProblema) {

        List<Incidencia> incidencias=incidenciaReprository.findAllByTipoProblema_Id(idTipoProblema);
        incidencias.forEach(i ->{ i.setTipoProblema(null);
                    incidenciaReprository.save(i);
                }
        );
    }
    @Override
    @Transactional
    public void updateTecnico(Integer idIncidencia, TecnicoDto tecnicoDto) {

        Incidencia incidencia = incidenciaReprository.findById(idIncidencia).orElse(null);
        incidencia.setTecnico(MapperEntity.mapper.toBean(tecnicoDto));
        incidenciaReprository.save(incidencia);

    }
    @Override
    @Transactional
    public void updateCliente(Integer idIncidencia, ClienteDto clienteDto) {
        Incidencia incidencia = incidenciaReprository.findById(idIncidencia).orElse(null);
        incidencia.setCliente(MapperEntity.mapper.toBean(clienteDto));
        incidenciaReprository.save(incidencia);


    }
    @Override
    @Transactional
    public void deleteAllCliente(Integer idCliente) {
        List<Incidencia> incidencias=incidenciaReprository.findAllByCliente_Id(idCliente);
        incidencias.forEach(i ->{ i.setCliente(null);
                    incidenciaReprository.save(i);
                }
        );

    }

    @Override
    @Transactional
    public void updateTipoProblema(Integer idIncidencia, TipoProblemaDto tipoProblemaDto) {

        Incidencia incidencia = incidenciaReprository.findById(idIncidencia).orElse(null);
        incidencia.setTipoProblema(MapperEntity.mapper.toBean(tipoProblemaDto));
        incidenciaReprository.save(incidencia);

    }




}
