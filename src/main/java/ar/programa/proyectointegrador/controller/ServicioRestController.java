package ar.programa.proyectointegrador.controller;


import ar.programa.proyectointegrador.dto.ServicioDto;

import ar.programa.proyectointegrador.service.IncidenciaDetalleService;
import ar.programa.proyectointegrador.service.ServicioService;
import lombok.RequiredArgsConstructor;
 import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/servicios")
public class ServicioRestController {

    private final  ServicioService servicioService;
    private final  IncidenciaDetalleService incidenciaDetalleService;
    @GetMapping("/all")
    public ResponseEntity<?> getAllServicios() {
        return ResponseEntity.ok(servicioService.findAll());

    }
    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> updateService(@Validated @RequestBody Map<String, Object> body,
                                     @PathVariable("id") Integer id) {

        ServicioDto servicioUpdateDto = servicioService.findById(id).get();
        String nombre= String.valueOf(body.get("nombre"));

        if(! nombre.isEmpty())
            servicioUpdateDto.setNombre(nombre);

        return  ResponseEntity.ok(servicioService.update(servicioUpdateDto));

    }
    @DeleteMapping("/delete/{id}")
    public  ResponseEntity<?> deleteServicioById(@PathVariable("id") Integer id){
        servicioService.deleteById(id);
        return  ResponseEntity.ok( "Servicio eliminado correctamente");
    }


    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?>  CreateServicio(@RequestBody Map<String, Object> body) {

        String nombre= String.valueOf(body.get("nombre"));
        ServicioDto servicioCreateDto=new ServicioDto();
        servicioCreateDto.setNombre(nombre);
        return ResponseEntity.ok(servicioService.save(servicioCreateDto));
    }

    @PutMapping("/addServicioDetalleincidencia/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> updateServicioDetalleIncidencia(@Validated @RequestBody Map<String,Object> body,
                                          @PathVariable("id") Integer id){

        String idDetalleIncidencia=String.valueOf(body.get("idDetalleIncidencia"));
        ServicioDto servicioDto= servicioService.addDetalleIncidencia(id,Integer.valueOf(idDetalleIncidencia));


            if(servicioDto!=null)
                return ResponseEntity.ok( "OK - Detalle de Incidencia "+ idDetalleIncidencia +" se agregado al servicio "+id);


        return ResponseEntity.ok("Fallo - No se agrego la Detalle de incidencia al servicio "+id);

    }






}
