package com.mdsacra.centraldeerros.service.implement;

import com.mdsacra.centraldeerros.entity.Evento;
import com.mdsacra.centraldeerros.level.Level;
import com.mdsacra.centraldeerros.repository.EventoRepository;
import com.mdsacra.centraldeerros.service.interfaces.EventoServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

    public Page<Evento> findAll(Pageable pageable){
        List<Evento> eventos = new ArrayList<>();
        eventoRepository.findAll(pageable).forEach(eventos::add);
        return new PageImpl<>(eventos);
    }

    @Override
    public Optional<Evento> findById(Integer id) {
        return eventoRepository.findById(id);
    }

    @Override
    public Page<Evento> findByLevel(Level level, Pageable pageable) {
        return eventoRepository.findByLevel(level, pageable);
    }

    @Override
    public Page<Evento> findByOrigem(String origem, Pageable pageable) {
        return eventoRepository.findByOrigem(origem, pageable);
    }

    @Override
    public Page<Evento> findByDescricao(String descricao, Pageable pageable) {
        return eventoRepository.findByDescricaoContaining(descricao, pageable);
    }

    @Override
    public Page<Evento> findByData(LocalDate dataInicial, LocalDate dataFinal, Pageable pageable) {
        return eventoRepository.findAllByDataBetween(dataInicial, dataFinal, pageable);
    }

}
