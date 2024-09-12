package com.unicauca.gestionhorarios.service.fachadaservices.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FranjaHorariaDTO {
    private Long id;
    private Long idCurso;
    private Long idEspacioFisico;
    private String dia;
    private String horaInicio;
    private String horaFin;
}
