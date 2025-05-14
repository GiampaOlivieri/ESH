package com.example.demo.data.dto;


import lombok.*;

import java.util.List;

@Setter
@Getter
public class CorsoDTO {

    private Long id;

    private String nome;

    private Integer annoAccademico;

    private DocenteDTO docente;

    private List<DiscenteDTO> discenti;
}
