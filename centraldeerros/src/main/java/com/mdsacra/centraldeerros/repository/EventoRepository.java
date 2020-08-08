package com.mdsacra.centraldeerros.repository;

import com.mdsacra.centraldeerros.entity.Evento;
import com.mdsacra.centraldeerros.level.Level;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Integer> {

    List<Evento> findByLevel(Level level);

    List<Evento> findByOrigem(String origem);

    List<Evento> findByLog(String log);

    List<Evento> findByDescricao(String descricao);

    List<Evento> findByData(String data);



}
