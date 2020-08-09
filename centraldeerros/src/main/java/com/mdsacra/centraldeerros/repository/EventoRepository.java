package com.mdsacra.centraldeerros.repository;

import com.mdsacra.centraldeerros.entity.Evento;
import com.mdsacra.centraldeerros.level.Level;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventoRepository extends PagingAndSortingRepository<Evento, Integer> {

    List<Evento> findByLevel(Level level, Pageable pageable);

    List<Evento> findByOrigem(String origem, Pageable pageable);

    List<Evento> findByLog(String log, Pageable pageable);

    List<Evento> findByDescricaoContaining(String descricao, Pageable pageable);

    List<Evento> findByData(String data, Pageable pageable);



}
