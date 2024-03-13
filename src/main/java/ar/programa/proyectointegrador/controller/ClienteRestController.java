package ar.programa.proyectointegrador.controller;
import ar.programa.proyectointegrador.dto.ClienteDto;
import ar.programa.proyectointegrador.service.ClienteService;
import ar.programa.proyectointegrador.service.IncidenciaService;
import ar.programa.proyectointegrador.service.ServicioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.Map;


@RestController
@RequestMapping("/api/clientes")
@RequiredArgsConstructor
public class ClienteRestController {

    private final ClienteService clienteService;
    private final ServicioService servicioService;
    private final IncidenciaService incidenciaService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createCliente(@RequestBody Map<String, Object> body) {

        String razonSocial= String.valueOf(body.get("razonSocial"));
        String cuit=String.valueOf(body.get("cuit"));
        String mail=String.valueOf(body.get("mail"));
        ClienteDto clienteCreatedto= new ClienteDto();
        clienteCreatedto.setMail(mail);
        clienteCreatedto.setCuit(cuit);

        return ResponseEntity.ok(clienteService.save(clienteCreatedto));

    }

    @PutMapping("/addClienteServicio/{id}")
    public ResponseEntity<?> updateClienteServicio(@Validated @RequestBody Map<String,Object> body,
                                         @PathVariable("id") Integer id){
           String idServicio=String.valueOf(body.get("idServicio"));
           ClienteDto  clienteDto= clienteService.addServicio(id,Integer.valueOf(idServicio));
           if(clienteDto!=null)
             return ResponseEntity.ok("OK - Servicio "+ idServicio +"agregado al cliente "+id);
           return ResponseEntity.ok("Fallo - No se agrego el servicio al cliente "+id);
    }

    @PutMapping("/addClienteIncidencia/{id}")
    public ResponseEntity<?> updateClienteIncidencia(@Validated @RequestBody Map<String,Object> body,
                                        @PathVariable("id") Integer id){
          String idIncidencia=String.valueOf(body.get("idIncidencia"));
          ClienteDto clienteDto= clienteService.addIncidencia(id,Integer.valueOf(idIncidencia));
            if(clienteDto!=null)
               return ResponseEntity.ok("OK - Incidencia "+ idIncidencia +"agregado al cliente "+id);
         return ResponseEntity.ok("Fallo - No se agrego la incidencia al cliente "+id);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateCliente( @RequestBody Map<String,Object> body,
                                    @PathVariable("id") Integer id) {

        ClienteDto clienteUpdateDto = clienteService.findById(id).get();
        String razonSocial= String.valueOf(body.get("razonSocial"));
        String cuit=String.valueOf(body.get("cuit"));
        String mail=String.valueOf(body.get("mail"));

        if( ! razonSocial.isEmpty() )
             clienteUpdateDto.setRazonSocial(razonSocial);
        if (! cuit.isEmpty() )
            clienteUpdateDto.setMail(mail) ;
        if (! mail.isEmpty())
             clienteUpdateDto.setCuit(cuit);
        return ResponseEntity.ok(clienteService.update(clienteUpdateDto));


    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllClientes() {
             return ResponseEntity.ok(clienteService.findAll());
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteClienteById(@PathVariable("id") Integer id){
        try{
           clienteService.deleteById(id);
          return ResponseEntity.ok( "Cliente Eliminado correctamente");
       }catch (Exception e) {
            return ResponseEntity.ok( "Cliente NO pudo ser Eliminado ");

        }
    }

}
