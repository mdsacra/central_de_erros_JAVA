package com.mdsacra.centraldeerros.repository;

import com.mdsacra.centraldeerros.entity.Evento;
import com.mdsacra.centraldeerros.level.Level;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Integer> {

    Page<Evento> findByLevel(Level level, Pageable pageable);

    Page<Evento> findByOrigem(String origem, Pageable pageable);

    Page<Evento> findByLog(String log, Pageable pageable);

    Page<Evento> findByDescricaoContaining(String descricao, Pageable pageable);

    Page<Evento> findByData(String data, Pageable pageable);



}
