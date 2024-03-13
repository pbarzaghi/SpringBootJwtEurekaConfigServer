package ar.programa.proyectointegrador.controller;

import ar.programa.proyectointegrador.dto.DetalleIncidenciaDto;
import ar.programa.proyectointegrador.service.IncidenciaDetalleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.Map;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/detallesIncidencias")
public class DetalleIncidenciaRestController {
    private final IncidenciaDetalleService incidenciaDetalleService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public   ResponseEntity<?> CreateDetalleIncidencia(@Validated @RequestBody Map<String, Object> body) {

        String descripcionProblema= String.valueOf(body.get("descripcionProblema"));
        String detalleProblema= String.valueOf(body.get("detalleProblema"));
        Boolean resuelto=  Boolean.valueOf((String) body.get("resuelto"));
        DetalleIncidenciaDto detalleIncidenciaCreateDto =new DetalleIncidenciaDto();
        detalleIncidenciaCreateDto .setDescripcionProblema(descripcionProblema);
        detalleIncidenciaCreateDto.setDetalleProblema(detalleProblema);
        return  ResponseEntity.ok(incidenciaDetalleService.save(detalleIncidenciaCreateDto));
    }
    @PutMapping("/update/{id}")
    public  ResponseEntity<?>  updateDetalleIncidencia(@Validated @RequestBody Map<String, Object> body,
                                     @PathVariable("id") Integer id) {
        DetalleIncidenciaDto detalleIncidenciaUpdateDto = incidenciaDetalleService.findById(id).get();
        String descripcionProblema= String.valueOf(body.get("descripcionProblema"));
        String detalleProblema= String.valueOf(body.get("detalleProblema"));
        String strResuelto= String.valueOf(body.get("resuelto"));

        if(! descripcionProblema.isEmpty())
            detalleIncidenciaUpdateDto.setDescripcionProblema(descripcionProblema);

        if(! detalleProblema.isEmpty())
            detalleIncidenciaUpdateDto.setDetalleProblema(detalleProblema);

        if(! strResuelto.isEmpty())
            detalleIncidenciaUpdateDto.setResuelto(Boolean.valueOf(strResuelto));
        return  ResponseEntity.ok(incidenciaDetalleService.update(detalleIncidenciaUpdateDto));
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllDetalleIncidencias() {
        return  ResponseEntity.ok(incidenciaDetalleService.findAll());

    }


    @DeleteMapping("/deleteBy/{id}")
    public  ResponseEntity<?> deleteServicioById(@PathVariable("id") Integer id){
       try {
           incidenciaDetalleService.deleteById(id);
           return ResponseEntity.ok("Detalle Incidencia fue eliminado correctamente");
       }catch (Exception e){
           return ResponseEntity.ok("Detalle Incidencia NO pudo ser borrado, chequear que no tengfue eliminado correctamente");
       }

    }
}
