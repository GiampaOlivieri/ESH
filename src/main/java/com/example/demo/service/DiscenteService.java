package com.example.demo.service;

import com.example.demo.util.DiscenteConverter;
import com.example.demo.data.dto.DiscenteDTO;
import com.example.demo.data.entity.Corso;
import com.example.demo.data.entity.Discente;
import com.example.demo.repository.CorsoRepository;
import com.example.demo.repository.DiscenteRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DiscenteService {
    @Autowired
    DiscenteRepository discenteRepository;

    @Autowired
    CorsoRepository corsoRepository;

    public List<DiscenteDTO> findAll() {
        return discenteRepository.findAll().stream()
                .map(DiscenteConverter::toDTO)
                .collect(Collectors.toList());
    }

    public DiscenteDTO get(Long id) {
        Discente discente = discenteRepository.findById(id).orElseThrow();
        return DiscenteConverter.toDTO(discente);
    }

    public DiscenteDTO save(DiscenteDTO d){
        Discente discente = DiscenteConverter.toEntity(d);
        Discente savedDiscente=discenteRepository.save(discente);
        return DiscenteConverter.toDTO(savedDiscente);
    }

    @Transactional
    public void delete(Long id){
        Discente discente = discenteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Discente non trovato"));

        List<Corso> corsi = corsoRepository.findByDiscente(discente);
        for (Corso corso : corsi) {
            corso.getDiscenti().remove(discente);
        }
        corsoRepository.saveAll(corsi);

        discenteRepository.delete(discente);

    }

    public List<DiscenteDTO> findByName(String nome) {
        return discenteRepository.findByName(nome).stream()
                .map(DiscenteConverter::toDTO)
                .collect(Collectors.toList());
    }
}
