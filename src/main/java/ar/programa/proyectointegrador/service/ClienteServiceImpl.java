package ar.programa.proyectointegrador.service;

import ar.programa.proyectointegrador.dto.ClienteDto;
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

/**
 @author pabloBarzaghi
 */
@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService{
    private final  ClienteRepository clienteRepository;
    @Transactional(readOnly = true)
    @Override
    public ResponseEntity<?> findAll()  {

        return   ResponseEntity.ok(MapperEntity.mapper.toDtoListCliente(clienteRepository.findAll()));
    }
    @Transactional
    @Override
    public Cliente save(Cliente cliente)   {
        return clienteRepository.save(cliente);
    }
    @Transactional
    @Override
    public Cliente update(Cliente cliente)  {
        return clienteRepository.save(cliente);
    }
    @Transactional
    @Override
    public Optional<Cliente> findById(Integer integer) {
        return clienteRepository.findById(integer);
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
    public Cliente addIncidencia(Cliente cliente, Incidencia incidencia) {
        List<Incidencia> listIncidencias=cliente.getIncidencias();
      if(!listIncidencias.contains(incidencia)) {
          listIncidencias.add(incidencia);
          cliente.setIncidencias(listIncidencias);
          incidencia.setCliente(cliente);
          return clienteRepository.save(cliente);
      }
     return null;
    }

    @Override
    public Cliente addServicio(Cliente cliente, Servicio servicio) {
        List<Servicio> listServicios=cliente.getServicios();
        if(!listServicios.contains(servicio)) {
            listServicios.add( servicio);
            cliente.setServicios(listServicios);
            return clienteRepository.save(cliente);
        }
        return null;
    }

    

}
