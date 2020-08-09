package com.mdsacra.centraldeerros.endpoints;

import com.mdsacra.centraldeerros.endpoints.advice.ResourceNotFoundException;
import com.mdsacra.centraldeerros.entity.Evento;
import com.mdsacra.centraldeerros.level.Level;
import com.mdsacra.centraldeerros.service.implement.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("/eventos")
public class EventoController {

    @Autowired
    private EventoService eventoService;

    @PostMapping
    public Evento salvarEvento(@Valid @RequestBody Evento evento){
        return this.eventoService.salvarEvento(evento);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Evento> findById(@PathVariable("id") Integer id){

        return new ResponseEntity<Evento>(eventoService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Evento")), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Iterable<Evento>> findEventoByLevel(@RequestParam(name = "level") Level level, Pageable pageable) {

        if (eventoService.findByLevel(level, pageable).isEmpty()) {
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Iterable<Evento>>(eventoService.findByLevel(level, pageable), HttpStatus.OK);
    }


}
