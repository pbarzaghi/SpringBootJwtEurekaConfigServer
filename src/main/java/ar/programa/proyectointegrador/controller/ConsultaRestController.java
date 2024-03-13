package ar.programa.proyectointegrador.controller;

import ar.programa.proyectointegrador.service.TecnicoService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;


import java.util.Map;
@RestController
@RequestMapping("/api/consultas")
@RequiredArgsConstructor
public class ConsultaRestController {

    private final TecnicoService tecnicoService;

    @GetMapping("/tecnicoConMasIncidentesResueltosNdias/{id}")
    public ResponseEntity<?> getTecnicoConMasIncidentesResueltos(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(tecnicoService.findTecnicosConMasIncidentesResueltosEnNDias(id));
    }

    @GetMapping("/tecnicoConMasIncidentesResueltosNdiasEspecialidad/{cantidaDias}")
    public ResponseEntity<?> getTecnicoConMasIncidentesResueltosEspecialidad(@RequestBody Map<String, Object> body,
                                                                             @PathVariable("cantidaDias") Integer cantidaDias) {

        Integer idEsp = Integer.valueOf(String.valueOf(body.get("idEspecialidad")));

        return ResponseEntity.ok(tecnicoService.findTecnicosConMasIncidentesResueltosEnNDiasEspecialidad(cantidaDias, idEsp));

    }

    @GetMapping("/tecnicoRapidoResolverIncidencia")
    public ResponseEntity<?> getTecnicoMasRapidoResolucionIncidencia() {
        return ResponseEntity.ok(tecnicoService.findTecnicoMasRapidoResolvioLaIncidencia());
    }
}