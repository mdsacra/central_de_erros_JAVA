package com.mdsacra.centraldeerros.entitymapper;

import com.mdsacra.centraldeerros.entity.Evento;
import com.mdsacra.centraldeerros.entitydto.EventoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EventoMapper {

    @Mappings({
            @Mapping(source = "level", target = "level"),
            @Mapping(source = "origem", target = "origem"),
            @Mapping(source = "descricao", target = "descricao"),
            @Mapping(source = "data", target = "data", dateFormat = "dd-MM-yyyy"),
            @Mapping(source = "quantidade", target = "quantidade") })
    EventoDTO map(Evento evento);

    default Page<EventoDTO> map(Page<Evento> eventos) {
        return eventos.map(this::map);
    }
}
