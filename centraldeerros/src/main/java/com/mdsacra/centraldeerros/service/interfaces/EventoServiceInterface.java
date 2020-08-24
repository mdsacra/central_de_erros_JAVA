package com.mdsacra.centraldeerros.service.interfaces;

import com.mdsacra.centraldeerros.entity.Evento;
import com.mdsacra.centraldeerros.level.Level;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface EventoServiceInterface {

    Optional<Evento> findById(Integer id);

    Page<Evento> findAll(Pageable pageable);

    Page<Evento> findByLevel(Level level, Pageable pageable);

    Page<Evento> findByOrigem(String origem, Pageable pageable);

    Page<Evento> findByDescricao(String descricao, Pageable pageable);

    Page<Evento> findByData(LocalDate dataInicial, LocalDate dataFinal, Pageable pageable);

    Evento salvarEvento(Evento evento);

}
