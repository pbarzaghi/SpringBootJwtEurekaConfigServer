package ar.programa.proyectointegrador.controller;

import ar.programa.proyectointegrador.dto.IncidenciaDto;
import ar.programa.proyectointegrador.service.IncidenciaDetalleService;
import ar.programa.proyectointegrador.service.IncidenciaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;


@RestController
@RequestMapping("/api/incidencias")
@RequiredArgsConstructor
public class IncidenciaRestController {

    private final IncidenciaService incidenciaService;
    private final IncidenciaDetalleService incidenciaDetalleService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> CreateIncidencia(@Validated @RequestBody Map<String, Object> body) {

        String alias = String.valueOf(body.get("alias"));
        String descripcion = String.valueOf(body.get("descripcion"));
        String fechaestimada = String.valueOf(body.get("fechaestimada"));
        String strResuelto = String.valueOf(body.get("resuelto")).toUpperCase();
        IncidenciaDto incidenciaCreateDto = new IncidenciaDto();
        incidenciaCreateDto.setAlias(alias);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime fecha = LocalDateTime.parse(fechaestimada, formatter);
        incidenciaCreateDto.setDescripcion(descripcion);
        incidenciaCreateDto.setFechaEstimada(LocalDateTime.parse(fechaestimada, formatter));
        if ( "TRUE".equals(strResuelto))
            incidenciaCreateDto.setResuelto(Boolean.TRUE);
        else
            incidenciaCreateDto.setResuelto(Boolean.FALSE);
       return ResponseEntity.ok( incidenciaService.save(incidenciaCreateDto));
    }

    @PutMapping("/addIncidenciaDetalleIncidencia/{id}")
    public ResponseEntity<?>  updateIncidenciaoDetalleIncidencia(@Validated @RequestBody Map<String,Object> body,
                                                  @PathVariable("id") Integer id){
        String idDetalleIncidencia=String.valueOf(body.get("idDetalleIncidencia"));

            IncidenciaDto incidenciaDto= incidenciaService.addDetalleIncidencia(id,
                    Integer.valueOf(idDetalleIncidencia));
            if(incidenciaDto!=null)
                return ResponseEntity.ok( "OK - Detalle de Incidencia "+ idDetalleIncidencia +" se agregado al Incidente "+id);
          return  ResponseEntity.ok("Fallo - No se agrego la Detalle de incidencia al Incidente "+id);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateIncidencia(@Validated @RequestBody Map<String, Object> body,
                                               @PathVariable("id") Integer id) {
        IncidenciaDto incidenciaUpdateDto = incidenciaService.findById(id).get();
        String alias= String.valueOf(body.get("alias"));
        String descripcion= String.valueOf(body.get("descripcion"));
        String fechaestimada= String.valueOf(body.get("fechaestimada"));
        String strResuelto=String.valueOf(body.get("resuelto")).toUpperCase();
        if(! alias.isEmpty())
            incidenciaUpdateDto.setAlias(alias);
        if (! descripcion.isEmpty())
           incidenciaUpdateDto.setDescripcion(descripcion);
        if (! fechaestimada.isEmpty()) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            incidenciaUpdateDto.setFechaEstimada(LocalDateTime.parse(fechaestimada,formatter));
        }
        if (! strResuelto.isEmpty() )
            incidenciaUpdateDto.setResuelto(Boolean.valueOf(strResuelto));
         return ResponseEntity.ok(incidenciaService.save(incidenciaUpdateDto));
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllIncidencias() {
        return ResponseEntity.ok(incidenciaService.findAll());
     }
   @DeleteMapping("/delete/{id}")
    public ResponseEntity<?>  deleteIncidenciaoById(@PathVariable("id") Integer id){
       try{
            incidenciaService.deleteById(id);
            return ResponseEntity.ok( "Incidencia eliminada correctamente");
        }catch (Exception e) {
            return ResponseEntity.ok( "La Incidencia NO pudo ser Eliminado ");
        }
    }

}
