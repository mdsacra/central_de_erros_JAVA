package com.mdsacra.centraldeerros.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Data
public class Usuario {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Integer id;

    @Column(nullable = false, length = 20)
    String userName;

    @Column(nullable = false, length = 10)
    String senha;

    @CreatedDate
    @Column
    @JsonFormat(pattern = "dd-MM-yyyy", timezone = "GMT-3")
    Date dataCadastro;


}
