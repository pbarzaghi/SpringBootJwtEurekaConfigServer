package ar.programa.proyectointegrador.controller;


import ar.programa.proyectointegrador.dto.TecnicoDto;
 import ar.programa.proyectointegrador.service.TecnicoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/tecnicos")
public class TecnicoRestController {

    private final TecnicoService tecnicoService;
     @PostMapping("/create")
     @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> CreateTecnico( @RequestBody Map<String, Object> body) {

        String nombre = String.valueOf(body.get("nombre"));
        String mail = String.valueOf(body.get("mail"));
        String numTelefono = String.valueOf(body.get("numTelefono"));

        TecnicoDto tecnicoCreateDto = new TecnicoDto();
        tecnicoCreateDto.setNombre(nombre);
        tecnicoCreateDto.setMail(mail);
        tecnicoCreateDto.setNroTel(numTelefono);
        return ResponseEntity.ok(tecnicoService.save(tecnicoCreateDto));

   }

    @PutMapping("/addTecnicoEspecialidad/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public  ResponseEntity<?>  updateTecnicoespecialidad(@RequestBody Map<String, Object> body,
                                            @PathVariable("id") Integer id) {

        String idEspecialidad = String.valueOf(body.get("idEspecialidad"));
        TecnicoDto tecnicoDto= tecnicoService.addEspecialidad(id,Integer.valueOf(idEspecialidad));
         if (tecnicoDto != null){
                return ResponseEntity.ok("OK - Especialidad " + idEspecialidad + " se agregado al tecnico " + id);
        }

        return ResponseEntity.ok("Fallo - No se agrego la especialidad al tecnico " + id);

    }

    @PutMapping("/addTecnicoIncidencia/{id}")
     public   ResponseEntity<?>  updateTecnicoIncidencia( @RequestBody Map<String, Object> body,
                                          @PathVariable("id") Integer id) {

            String idIncidencia = String.valueOf(body.get("idIncidencia"));
            TecnicoDto tecnicoDto= tecnicoService.addIncidencia(id,Integer.valueOf(idIncidencia ));
            if (tecnicoDto != null){
                return ResponseEntity.ok("OK - Incidencia " + idIncidencia + " es agregado al tecnico " + id);
        }

          return ResponseEntity.ok("Fallo - No se agrego la incidencia al tecnico " + id);

    }
    @PutMapping("/update/{id}")

    public ResponseEntity<?> updateTecnico( @RequestBody Map<String, Object> body,
                                    @PathVariable("id") Integer id) {

        TecnicoDto tecnicoUpdateDto = tecnicoService.findById(id).get();
        String nombre = String.valueOf(body.get("nombre"));
        String mail = String.valueOf(body.get("mail"));
        String numTelefono = String.valueOf(body.get("numTelefono"));
        if(! nombre.isEmpty())
            tecnicoUpdateDto.setNombre(nombre);
        if (! mail.isEmpty())
            tecnicoUpdateDto.setMail(mail);
        if (! numTelefono.isEmpty())
            tecnicoUpdateDto.setNroTel(numTelefono);
       return ResponseEntity.ok(tecnicoService.update(tecnicoUpdateDto));
      }

   @GetMapping("/all")
   public ResponseEntity<?> getAllTecnicos() {
        return ResponseEntity.ok(tecnicoService.findAll());

   }
  @DeleteMapping("/delete/{id}")

   public ResponseEntity<?> deleteTecnicoById(@PathVariable("id") Integer id){
      try {

          tecnicoService.deleteById(id);
          return ResponseEntity.ok("Tecnico Eliminado correctamente");
      }catch (Exception e){
          return ResponseEntity.ok("Tecnico No pudo ser Eliminado ");
      }
   }

   }

