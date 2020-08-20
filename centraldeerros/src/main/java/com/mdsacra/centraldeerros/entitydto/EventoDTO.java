package com.mdsacra.centraldeerros.entitydto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mdsacra.centraldeerros.level.Level;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventoDTO {

    Level level;
    String origem;
    String descricao;
    @JsonFormat(pattern = "dd-MM-yyyy")
    LocalDate data;
    Integer quantidade;

}
