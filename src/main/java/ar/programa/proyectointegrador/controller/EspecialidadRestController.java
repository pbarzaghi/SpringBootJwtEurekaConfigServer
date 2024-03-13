package ar.programa.proyectointegrador.controller;

import ar.programa.proyectointegrador.dto.EspecialidadDto;
import ar.programa.proyectointegrador.service.EspecialidadService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
 import java.util.Map;


@RestController
@RequestMapping("/api/especialidades")
@RequiredArgsConstructor
public class EspecialidadRestController {

    private final  EspecialidadService especialidadService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> CreateEspecialidad(@Validated @RequestBody Map<String, Object> body) {

        String nombre= String.valueOf(body.get("nombre"));
        EspecialidadDto especialidadDto=new EspecialidadDto();
        especialidadDto.setNombre(nombre);
        return  ResponseEntity.ok(especialidadService.save(especialidadDto));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?>  updateEspecialidad(@Validated @RequestBody Map<String, Object> body,
                                     @PathVariable("id") Integer id) {

        EspecialidadDto especialidadUpdateDto = especialidadService.findById(id).get();
        String nombre= String.valueOf(body.get("nombre"));
        if(! nombre.isEmpty())
            especialidadUpdateDto.setNombre(nombre);
        return ResponseEntity.ok(especialidadService.update(especialidadUpdateDto));
   }

    @GetMapping("/all")
    public ResponseEntity<?>  getAllEspecialidades() {
         return ResponseEntity.ok(especialidadService.findAll());

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEspecialidadById(@PathVariable("id") Integer id){
        try{
            especialidadService.deleteById(id);
            return ResponseEntity.ok( "Especialidad eliminado correctamente");
        }catch (Exception e) {
            return ResponseEntity.ok( "specialidad NO pudo ser Eliminado ");

        }
    }

}
