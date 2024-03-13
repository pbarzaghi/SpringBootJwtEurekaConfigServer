package ar.programa.proyectointegrador.controller;

import ar.programa.proyectointegrador.dto.TipoProblemaDto;
 import ar.programa.proyectointegrador.service.EspecialidadService;
import ar.programa.proyectointegrador.service.IncidenciaService;
import ar.programa.proyectointegrador.service.TipoProblemaService;
import lombok.RequiredArgsConstructor;
 import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/tipoProblemas")
@RequiredArgsConstructor
public class TipoProblemaRestController {
    private final  TipoProblemaService tipoProblemaService;
    private final  EspecialidadService especialidadService;
    private final  IncidenciaService incidenciaService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?>createTipoproblema(@Validated @RequestBody Map<String, Object> body) {

        String tiempoEstimado= String.valueOf(body.get("tiempoEstimado"));
        String tipo=String.valueOf(body.get("tipo"));

        TipoProblemaDto tipoProblemaCreateDto=new TipoProblemaDto();
        tipoProblemaCreateDto.setTiempoEnDias(Integer.valueOf(tiempoEstimado));
        tipoProblemaCreateDto.setTipo(tipo);
        return ResponseEntity.ok(tipoProblemaService.save(tipoProblemaCreateDto));

    }

    // Update
    @PutMapping("/addTipoProblemaEspecialidad/{id}")
    public ResponseEntity<?> updateTipoProblemaEspecialidad(@Validated @RequestBody Map<String,Object> body,
                                        @PathVariable("id") Integer id){

            String idEspecialidad=String.valueOf(body.get("idEspecialidad"));
            TipoProblemaDto tipoProblemaDto= tipoProblemaService.addEspecialidad(id,
                    Integer.valueOf(idEspecialidad));
            if(tipoProblemaDto!=null)
                return ResponseEntity.ok( "OK - La especialidad "+ idEspecialidad +" tiene agregado  tipo de problema  "+id);
            return ResponseEntity.ok(  "Fallo - No se agrego el servicio al cliente "+id);

    }

    @PutMapping("/addTipoproblemaIncidencia/{id}")
    public ResponseEntity<?> updateTipoProblemaIncidencia(@Validated @RequestBody Map<String,Object> body,
                                          @PathVariable("id") Integer id){
             String idIncidencia=String.valueOf(body.get("idIncidencia"));

            TipoProblemaDto tipoProblemaDto= tipoProblemaService.addIncidencia(id,Integer.valueOf(idIncidencia ));
             if(tipoProblemaDto!=null) {
                          return ResponseEntity.ok( "OK - Incidencia " + idIncidencia + " se agregado al tipo problema " + id);
            }
        return ResponseEntity.ok( "Fallo - No se agrego la incidencia al tipo de problema "+id);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateTipoproblema(@Validated @RequestBody Map<String, Object> body,
                                     @PathVariable("id") Integer id) {

        TipoProblemaDto tipoProblemaUpdateDto = tipoProblemaService.findById(id).get();
        String tiempoEstimado= String.valueOf(body.get("tiempoEstimado"));
        String tipo=String.valueOf(body.get("tipo"));

        if(! tipo.isEmpty())
            tipoProblemaUpdateDto.setTipo(tipo);

        if(! tiempoEstimado.isEmpty())
            tipoProblemaUpdateDto.setTiempoEnDias(Integer.valueOf(tiempoEstimado));

        return ResponseEntity.ok(tipoProblemaService.update(tipoProblemaUpdateDto));



    }


    @GetMapping("/all")
    public ResponseEntity<?>getAllTipoProblemas() {
        return ResponseEntity.ok(tipoProblemaService.findAll());
   }
    @DeleteMapping("/delete/{id}")
    public  ResponseEntity<?> deleteTipoProblemaById(@PathVariable("id") Integer id){
        try {
             tipoProblemaService.deleteById(id);
             return ResponseEntity.ok("Tipo de problema fue eliminado correctamente");
        }catch (Exception e){
             return ResponseEntity.ok("ipo de problema No pudo ser Eliminado ");
            }
       }



}

