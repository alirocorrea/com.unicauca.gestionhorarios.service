package com.unicauca.gestionhorarios.service.capacontroladores;

import com.unicauca.gestionhorarios.service.fachadaservices.FranjaHorariaService;
import com.unicauca.gestionhorarios.service.fachadaservices.dto.FranjaHorariaDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/franja-horaria")
public class FranjaHorariaController {

    private final FranjaHorariaService franjaHorariaService;

    @GetMapping
    public List<FranjaHorariaDTO> listarFranjas() {
        return franjaHorariaService.findAll();
    }

    @GetMapping("/{id}")
    public FranjaHorariaDTO consultarFranja(@PathVariable final Long id) {
        return franjaHorariaService.findById(id);
    }

    @PostMapping
    public FranjaHorariaDTO crearCliente(@RequestBody FranjaHorariaDTO franjaHoraria) {
        return franjaHorariaService.save(franjaHoraria);
    }

    @PutMapping("/{id}")
    public FranjaHorariaDTO actualizarCliente(@RequestBody FranjaHorariaDTO franjaHoraria, @PathVariable Long id) {
        return franjaHorariaService.update(id, franjaHoraria);
    }

    @DeleteMapping
    public Boolean eliminarCliente(@RequestParam Long id) {
        return franjaHorariaService.delete(id);
    }
}
