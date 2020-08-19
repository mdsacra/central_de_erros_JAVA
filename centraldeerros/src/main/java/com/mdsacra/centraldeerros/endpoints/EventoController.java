package com.mdsacra.centraldeerros.endpoints;

import com.mdsacra.centraldeerros.endpoints.advice.ResourceNotFoundException;
import com.mdsacra.centraldeerros.entity.Evento;
import com.mdsacra.centraldeerros.entitydto.EventoDTO;
import com.mdsacra.centraldeerros.entitymapper.EventoMapper;
import com.mdsacra.centraldeerros.level.Level;
import com.mdsacra.centraldeerros.service.implement.EventoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/eventos")
public class EventoController {

    @Autowired
    private EventoService eventoService;

    @Autowired
    private EventoMapper eventoDtoMapper;

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
    public ResponseEntity<List<EventoDTO>> findEventos(@RequestParam(name = "page", required = false) Pageable pageable,
                                                       @RequestParam(name = "level", required = false) Level level,
                                                       @RequestParam(name = "origem", required = false) String origem,
                                                       @RequestParam(name = "descricao", required = false) String descricao,
                                                       @RequestParam(name = "data", required = false) String data) {


        if (eventoService.findAll().isEmpty()) {
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NO_CONTENT);
        } else {
            if (level != null) {
                return new ResponseEntity<>(this.eventoDtoMapper.map(eventoService.findByLevel(level, pageable)), HttpStatus.OK);
            } else if (origem != null) {
                return new ResponseEntity<>(this.eventoDtoMapper.map(eventoService.findByOrigem(origem, pageable)), HttpStatus.OK);
            } else if (descricao != null) {
                return new ResponseEntity<>(this.eventoDtoMapper.map(eventoService.findByDescricao(descricao, pageable)), HttpStatus.OK);
            } else if (data != null) {
                return new ResponseEntity<>(this.eventoDtoMapper.map(eventoService.findByData(data, pageable)), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(this.eventoDtoMapper.map(eventoService.findAll()), HttpStatus.OK);
            }
        }
    }
}
