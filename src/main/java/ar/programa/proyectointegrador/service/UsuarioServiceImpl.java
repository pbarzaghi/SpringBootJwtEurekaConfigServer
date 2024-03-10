package ar.programa.proyectointegrador.service;

import ar.programa.proyectointegrador.entity.Usuario;
import ar.programa.proyectointegrador.mapper.MapperEntity;
import ar.programa.proyectointegrador.repository.UsuarioRepository;


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
public class UsuarioServiceImpl implements UsuarioService{

    private final  UsuarioRepository usuarioRepository;
    @Transactional(readOnly = true)
    @Override
    public ResponseEntity<?> findAll()  {
        return   ResponseEntity.ok(MapperEntity.mapper.toDtoListUsuario(
                usuarioRepository.findAll())
                );
    }

    @Transactional
    @Override
    public Usuario save(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    @Transactional
    @Override
    public Usuario update(Usuario usuario)  {
        return usuarioRepository.save(usuario);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Usuario> findById(Integer integer)  {
        return usuarioRepository.findById(integer);
    }

    @Transactional
    @Override
    public void deleteById(Integer integer)  {
        usuarioRepository.deleteById(integer);
    }

    @Transactional
    public void deleteAll()   {
        usuarioRepository.deleteAll();
    }
}
