package com.mdsacra.centraldeerros.service.implement;

import com.mdsacra.centraldeerros.entity.Evento;
import com.mdsacra.centraldeerros.level.Level;
import com.mdsacra.centraldeerros.repository.EventoRepository;
import com.mdsacra.centraldeerros.service.interfaces.EventoServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventoService implements EventoServiceInterface {

    @Autowired
    EventoRepository eventoRepository;

    @Override
    public Optional<Evento> findById(Integer id) {
        return eventoRepository.findById(id);
    }

    @Override
    public List<Evento> findByLevel(Level level) {
        return eventoRepository.findByLevel(level);
    }

    @Override
    public List<Evento> findByOrigem(String origem) {
        return eventoRepository.findByOrigem(origem);
    }

    @Override
    public List<Evento> findByLog(String log) {
        return eventoRepository.findByLog(log);
    }

    @Override
    public List<Evento> findByDescricao(String descricao) {
        return eventoRepository.findByDescricao(descricao);
    }

    @Override
    public List<Evento> findByData(String data) {
        return eventoRepository.findByData(data);
    }
}
