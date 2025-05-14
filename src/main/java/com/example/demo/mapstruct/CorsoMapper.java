package com.example.demo.mapstruct;

import com.example.demo.data.dto.CorsoDTO;
import com.example.demo.data.dto.DiscenteDTO;
import com.example.demo.data.dto.DocenteDTO;
import com.example.demo.data.entity.Corso;
import com.example.demo.data.entity.Discente;
import com.example.demo.data.entity.Docente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {DocenteMapper.class, DiscenteMapper.class})
public interface CorsoMapper {

    @Mapping(target = "docenteId", source = "docente.id")
    @Mapping(target = "discentiIds", expression = "java(corso.getDiscenti().stream().map(d -> d.getId()).toList())")
    CorsoDTO corsoToDto(Corso corso);

    @Mapping(target = "docente.id", source = "docenteId")
    @Mapping(target = "discenti", ignore = true) // li carichi tu
    Corso corsoToEntity(CorsoDTO corsoDTO);
}
