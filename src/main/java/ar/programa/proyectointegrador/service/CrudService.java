package ar.programa.proyectointegrador.service;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author pbarzaghi
 */
public interface CrudService<T,ID> {
    ResponseEntity<?> findAll() ;
    T save(T t);
    T update(T t);
    Optional<T> findById(ID id) ;
    void deleteById(ID id);
    void deleteAll() ;



}