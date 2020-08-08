package com.mdsacra.centraldeerros.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mdsacra.centraldeerros.level.Level;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Data
public class Evento {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(nullable = false)
    Level level;

    @Column(nullable = false, length = 100)
    String origem;

    @Column(nullable = false, length = 100)
    String log;

    @Column(nullable = false)
    String descricao;

    @Column
    @JsonFormat(pattern = "dd-MM-yyyy")
    Date data;

    @Column
    Integer quantidade;

}
