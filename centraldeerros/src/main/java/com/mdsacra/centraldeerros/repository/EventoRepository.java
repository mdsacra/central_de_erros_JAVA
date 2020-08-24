package com.mdsacra.centraldeerros.repository;

import com.mdsacra.centraldeerros.entity.Evento;
import com.mdsacra.centraldeerros.level.Level;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EventoRepository extends PagingAndSortingRepository<Evento, Integer> {

    Page<Evento> findByLevel(Level level, Pageable pageable);

    Page<Evento> findByOrigem(String origem, Pageable pageable);

    Page<Evento> findByDescricaoContaining(String descricao, Pageable pageable);

    Page<Evento> findAllByDataBetween(LocalDate dataInicial, LocalDate dataFinal, Pageable pageable);



}
