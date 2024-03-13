package ar.programa.proyectointegrador.service;

import ar.programa.proyectointegrador.entity.TipoUsuario;
import ar.programa.proyectointegrador.mapper.MapperEntity;
import ar.programa.proyectointegrador.repository.TipoUsuarioRepository;
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
public class TipoUsuarioServiceImpl implements TipoUsuarioService{
    private final  TipoUsuarioRepository tipoUsuarioRepository;
    @Transactional(readOnly = true)
    @Override
    public ResponseEntity<?> findAll(){
        return   ResponseEntity.ok(MapperEntity.mapper.toDtoListTipoUsuario(
                tipoUsuarioRepository.findAll())
        );
    }
    @Transactional(readOnly = true)
    @Override
    public TipoUsuario save(TipoUsuario tipoUsuario) {
        return tipoUsuarioRepository.save(tipoUsuario);
    }
    @Transactional(readOnly = true)
    @Override
    public TipoUsuario update(TipoUsuario tipoUsuario)  {
        return tipoUsuarioRepository.save(tipoUsuario);
    }
    @Transactional(readOnly = true)
    @Override
    public Optional<TipoUsuario> findById(Integer integer)  {
        return tipoUsuarioRepository.findById(integer);
    }
    @Transactional
    @Override
    public void deleteById(Integer integer)  {
        tipoUsuarioRepository.findById(integer);
    }
    @Transactional
    @Override
    public void deleteAll() {
        tipoUsuarioRepository.deleteAll();
    }

}
