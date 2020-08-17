package com.mdsacra.centraldeerros.entitydto;

import com.mdsacra.centraldeerros.level.Level;
import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventoDTO {

    Level level;
    String origem;
    String descricao;
    Date data;
    Integer quantidade;

}
