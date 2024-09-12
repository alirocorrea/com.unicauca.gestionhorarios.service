package com.unicauca.gestionhorarios.service.capaaccesodatos.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FranjaHorariaEntity {
    private Long id;
    private Long idCurso;
    private Long idEspacioFisico;
    private String dia;
    private String horaInicio;
    private String horaFin;
}
