package ar.programa.proyectointegrador.service;


import ar.programa.proyectointegrador.dto.ClienteDto;
import ar.programa.proyectointegrador.dto.IncidenciaDto;
import ar.programa.proyectointegrador.dto.ServicioDto;
import ar.programa.proyectointegrador.entity.Cliente;
import ar.programa.proyectointegrador.entity.Incidencia;
import ar.programa.proyectointegrador.entity.Servicio;
import ar.programa.proyectointegrador.mapper.MapperEntity;
import ar.programa.proyectointegrador.repository.ClienteRepository;
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
public class ClienteServiceImpl implements ClienteService {
    private final  ClienteRepository clienteRepository;
    private final IncidenciaService incidenciaService;
    private final ServicioService servicioService;
    @Transactional(readOnly = true)
    @Override
    public ResponseEntity<?> findAll()  {

        return   ResponseEntity.ok(MapperEntity.mapper.toDtoListCliente(clienteRepository.findAll()));
    }
    @Transactional
    @Override
    public ClienteDto save(ClienteDto clienteDto)   {

        return MapperEntity.mapper.toDto(
                clienteRepository.save(  MapperEntity.mapper.toBean(clienteDto)));

    }
    @Transactional
    @Override
    public ClienteDto update(ClienteDto clienteDto)  {
        return MapperEntity.mapper.toDto(
                clienteRepository.save(  MapperEntity.mapper.toBean(clienteDto)));
    }
    @Transactional
    @Override
    public Optional<ClienteDto> findById(Integer integer) {
        Cliente cliente = clienteRepository.findById(integer).orElse(null);

        if ( cliente == null)
            return Optional.ofNullable(ClienteDto.builder().build());
        else
            return Optional.ofNullable(MapperEntity.mapper.toDto(cliente));
    }

    @Transactional
    @Override
    public void deleteById(Integer integer)   {
        clienteRepository.deleteById(integer);
    }

    @Override
    public void deleteAll()  {
        clienteRepository.deleteAll();
    }
    @Transactional
    @Override
    public ClienteDto addIncidencia(Integer idCliente, Integer idIncidencia) {

        Cliente cliente = clienteRepository.findById(idCliente).orElse(null);

        if(cliente != null) {
            //TODO: llamar a restTemp
            Incidencia incidencia=MapperEntity.mapper.toBean(incidenciaService.findById(idIncidencia).get());
            List<Incidencia> listIncidencias = cliente.getIncidencias();
            if (!listIncidencias.contains(incidencia)) {
                listIncidencias.add(incidencia);
                cliente.setIncidencias(listIncidencias);
                incidenciaService.updateCliente(idIncidencia, MapperEntity.mapper.toDto(cliente)   );
                return MapperEntity.mapper.toDto(clienteRepository.save(cliente));
            }
        }
     return null;
    }

    @Override
    public ClienteDto addServicio(Integer idCliente, Integer idServicio) {
        Cliente cliente = clienteRepository.findById(idCliente).orElse(null);

        if(cliente != null) {
            //TODO: llamar a restTemp
            Servicio servicio = MapperEntity.mapper.toBean(servicioService.findById(idServicio).get());
            List<Servicio> listServicios = cliente.getServicios();
            if (!listServicios.contains(servicio)) {
                listServicios.add(servicio);
                cliente.setServicios(listServicios);
                return MapperEntity.mapper.toDto(clienteRepository.save(cliente));

            }
        }
        return null;
    }

    

}
