package com.mdsacra.centraldeerros.service.implement;

import com.mdsacra.centraldeerros.entity.Evento;
import com.mdsacra.centraldeerros.level.Level;
import com.mdsacra.centraldeerros.repository.EventoRepository;
import com.mdsacra.centraldeerros.service.interfaces.EventoServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EventoService implements EventoServiceInterface {

    @Autowired
    EventoRepository eventoRepository;

    @Override
    public Evento salvarEvento(Evento evento) {
        return this.eventoRepository.save(evento);
    }

    public List<Evento> findAll(){
        List<Evento> eventos = new ArrayList<>();
        eventoRepository.findAll().forEach(eventos::add);
        return eventos;
    }

    @Override
    public Optional<Evento> findById(Integer id) {
        return eventoRepository.findById(id);
    }

    @Override
    public List<Evento> findByLevel(Level level, Pageable pageable) {
        return eventoRepository.findByLevel(level, pageable);
    }

    @Override
    public List<Evento> findByOrigem(String origem, Pageable pageable) {
        return eventoRepository.findByOrigem(origem, pageable);
    }

    @Override
    public List<Evento> findByLog(String log, Pageable pageable) {
        return eventoRepository.findByLog(log, pageable);
    }

    @Override
    public List<Evento> findByDescricao(String descricao, Pageable pageable) {
        return eventoRepository.findByDescricaoContaining(descricao, pageable);
    }

    @Override
    public List<Evento> findByData(String data, Pageable pageable) {
        return eventoRepository.findByData(data, pageable);
    }

}
