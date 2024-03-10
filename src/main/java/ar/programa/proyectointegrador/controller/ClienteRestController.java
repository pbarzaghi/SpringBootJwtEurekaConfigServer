package ar.programa.proyectointegrador.controller;

import ar.programa.proyectointegrador.dto.ClienteDto;
import ar.programa.proyectointegrador.dto.TecnicoDto;
import ar.programa.proyectointegrador.entity.Cliente;
import ar.programa.proyectointegrador.entity.Incidencia;
import ar.programa.proyectointegrador.entity.Servicio;
import ar.programa.proyectointegrador.entity.Tecnico;
import ar.programa.proyectointegrador.service.ClienteService;
import ar.programa.proyectointegrador.service.IncidenciaService;
import ar.programa.proyectointegrador.service.ServicioService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/clientes")
@RequiredArgsConstructor
public class ClienteRestController {

    private final ClienteService clienteService;
    private final ServicioService servicioService;
    private final IncidenciaService incidenciaService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> CreateCliente(@RequestBody Map<String, Object> body) {

        String razonSocial= String.valueOf(body.get("razonSocial"));
        String cuit=String.valueOf(body.get("cuit"));
        String mail=String.valueOf(body.get("mail"));

        Cliente clienteCreate=Cliente.builder()
                             .razonSocial(razonSocial)
                             .cuit(cuit).mail(mail)
                             .build();


        return ResponseEntity.ok(clienteService.save(clienteCreate));

    }
    // Update
    @PutMapping("/clienteServicio/{id}")
    public ResponseEntity<?> updateClienteServicio(@Validated @RequestBody Map<String,Object> body,
                                         @PathVariable("id") Integer id){
        Cliente cliente=   clienteService.findById(id).get();
        if(cliente != null){
            String idServicio=String.valueOf(body.get("idServicio"));
            Servicio servicio= ( servicioService.findById(Integer.valueOf(idServicio)).get() );
           cliente= clienteService.addServicio(cliente,servicio);
           if(cliente!=null)
               return ResponseEntity.ok("OK - Servicio "+ idServicio +"agregado al cliente "+id);

            }
        return ResponseEntity.ok("Fallo - No se agrego el servicio al cliente "+id);


    }

    @PutMapping("/clienteIncidencia/{id}")
    public ResponseEntity<?> updateClienteIncidencia(@Validated @RequestBody Map<String,Object> body,
                                        @PathVariable("id") Integer id){
        Cliente cliente=clienteService.findById(id).get();
        if(cliente != null){
            String idIncidencia=String.valueOf(body.get("idIncidencia"));
            Incidencia incidencia=  incidenciaService.findById(Integer.valueOf(idIncidencia)).get();
            cliente= clienteService.addIncidencia(cliente,incidencia);
            if(cliente!=null)
               return ResponseEntity.ok("OK - Incidencia "+ idIncidencia +"agregado al cliente "+id);
        }

        return ResponseEntity.ok("Fallo - No se agrego la incidencia al cliente "+id);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateCliente(@RequestBody Map<String, Object> body,
                                    @PathVariable("id") Integer id) {

        Cliente clienteUpdate = clienteService.findById(id).get();
        String razonSocial= String.valueOf(body.get("razonSocial"));
        String cuit=String.valueOf(body.get("cuit"));
        String mail=String.valueOf(body.get("mail"));

        if( ! razonSocial.isEmpty() )
             clienteUpdate.setRazonSocial(razonSocial);
        if (! mail.isEmpty() )
            clienteUpdate.setMail(mail) ;
        if (! cuit.isEmpty())
             clienteUpdate.setCuit(cuit);


            return ResponseEntity.ok(clienteService.update(clienteUpdate));
//        clienteUpdate=clienteService.update(clienteUpdate);
//
//        return ClienteDto.builder().razonSocial(clienteUpdate.getRazonSocial())
//                .mail(clienteUpdate.getMail())
//                .cuit(clienteUpdate.getCuit()).build();


    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllClientes() {

             return ResponseEntity.ok(clienteService.findAll());
 
     /*    return ResponseEntity.ok(clienteList.stream()
                 .map(t -> ClienteDto.builder()
                         .razonSocial(t.getRazonSocial())
                        .cuit(t.getCuit())
                        .mail(t.getMail())
                        .build())
                .collect(Collectors.toList()));
    */
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteClienteById(@PathVariable("id") Integer id){
        clienteService.deleteById(id);
        return ResponseEntity.ok( "Cliente Eliminado correctamente");
    }

}
