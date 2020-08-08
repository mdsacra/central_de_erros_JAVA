package com.mdsacra.centraldeerros.endpoints;

import com.mdsacra.centraldeerros.endpoints.advice.ResourceNotFoundException;
import com.mdsacra.centraldeerros.entity.Evento;
import com.mdsacra.centraldeerros.level.Level;
import com.mdsacra.centraldeerros.service.implement.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/eventos")
public class EventoController {

    @Autowired
    private EventoService eventoService;

    @GetMapping("/{id}")
    public ResponseEntity<Evento> findById(@PathVariable("id") Integer id){

        return new ResponseEntity<Evento>(eventoService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Evento")), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Evento>> findEventos(@RequestParam(name = "level", required = false) Level level){

        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.OK);
    }

}
