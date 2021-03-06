package com.mdsacra.centraldeerros.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mdsacra.centraldeerros.level.Level;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Data
@AllArgsConstructor
@NoArgsConstructor
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
    LocalDate data;

    @Column
    Integer quantidade;

}
