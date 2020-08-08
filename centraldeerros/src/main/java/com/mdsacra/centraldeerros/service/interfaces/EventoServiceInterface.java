package com.mdsacra.centraldeerros.service.interfaces;

import com.mdsacra.centraldeerros.entity.Evento;
import com.mdsacra.centraldeerros.level.Level;

import java.util.List;
import java.util.Optional;

public interface EventoServiceInterface {

    Optional<Evento> findById(Integer id);

    List<Evento> findByLevel(Level level);

    List<Evento> findByOrigem(String origem);

    List<Evento> findByLog(String log);

    List<Evento> findByDescricao(String descricao);

    List<Evento> findByData(String data);

    Evento salvarEvento(Evento evento);

}
