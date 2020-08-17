package com.mdsacra.centraldeerros.service.interfaces;

import com.mdsacra.centraldeerros.entity.Evento;
import com.mdsacra.centraldeerros.level.Level;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface EventoServiceInterface {

    Optional<Evento> findById(Integer id);

    List<Evento> findAll();

    List<Evento> findByLevel(Level level, Pageable pageable);

    List<Evento> findByOrigem(String origem, Pageable pageable);

    List<Evento> findByDescricao(String descricao, Pageable pageable);

    List<Evento> findByData(String data, Pageable pageable);

    Evento salvarEvento(Evento evento);

}
