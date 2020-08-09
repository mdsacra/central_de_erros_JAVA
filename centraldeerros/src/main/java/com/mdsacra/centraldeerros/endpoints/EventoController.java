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
    public ResponseEntity<?> findEventos(@RequestParam(name = "page", required = false) Pageable pageable,
                                         @RequestParam(name = "level", required = false) Level level,
                                         @RequestParam(name = "origem", required = false) String origem,
                                         @RequestParam(name = "log", required = false) String log,
                                         @RequestParam(name = "descricao", required = false) String descricao) {

        if (eventoService.findAll().isEmpty()) {
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NO_CONTENT);
        } else {
            if (level != null) {
                return new ResponseEntity<>(eventoService.findByLevel(level, pageable), HttpStatus.OK);
            } else if (origem != null) {
                return new ResponseEntity<>(eventoService.findByOrigem(origem, pageable), HttpStatus.OK);
            } else if (log != null) {
                return new ResponseEntity<>(eventoService.findByLog(log, pageable), HttpStatus.OK);
            } else if (descricao != null) {
                return new ResponseEntity<>(eventoService.findByDescricao(descricao, pageable), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(eventoService.findAll(), HttpStatus.OK);
            }
        }
    }
}
