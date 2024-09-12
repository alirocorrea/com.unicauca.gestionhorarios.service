package com.unicauca.gestionhorarios.service.fachadaservices;

import com.unicauca.gestionhorarios.service.fachadaservices.dto.FranjaHorariaDTO;

import java.util.List;

public interface FranjaHorariaService {

    List<FranjaHorariaDTO> findAll();

    FranjaHorariaDTO findById(Long id);

    FranjaHorariaDTO save(FranjaHorariaDTO cliente);

    FranjaHorariaDTO update(Long id, FranjaHorariaDTO cliente);

    boolean delete(Long id);
}
