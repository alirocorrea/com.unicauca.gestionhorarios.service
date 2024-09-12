package com.unicauca.gestionhorarios.service.capaaccesodatos.repositories;

import com.unicauca.gestionhorarios.service.capaaccesodatos.models.FranjaHorariaEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class FranjaHorariaRepository {

    private final List<FranjaHorariaEntity> listaFranjaHorarias;

    public FranjaHorariaRepository() {
        this.listaFranjaHorarias = new ArrayList<>();
        cargarfranjas();
    }

    public List<FranjaHorariaEntity> findAll() {
        System.out.println("Invocando listar franjas");
        return new ArrayList<>(this.listaFranjaHorarias);
    }

    public FranjaHorariaEntity findById(final Long id) {
        System.out.println("Invocando a consultar un franja");
        return this.listaFranjaHorarias.stream()
                .filter(franja -> franja.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public FranjaHorariaEntity save(final FranjaHorariaEntity franja) {
        System.out.println("Invocando a almacenar franja");
        this.listaFranjaHorarias.add(franja);
        return franja;
    }

    public FranjaHorariaEntity update(final Long id, final FranjaHorariaEntity nuevaFranjaHoraria) {
        System.out.println("Invocando a actualizar una franja");
        Optional<FranjaHorariaEntity> franjaHoraria = listaFranjaHorarias.stream()
                .filter(c -> Objects.equals(c.getId(), id))
                .findFirst();

        franjaHoraria.ifPresent(c -> {
            int index = listaFranjaHorarias.indexOf(c);
            listaFranjaHorarias.set(index, nuevaFranjaHoraria);
        });

        return franjaHoraria.isPresent() ? nuevaFranjaHoraria : null;
    }

    public boolean delete(final Long id) {
        System.out.println("Invocando a eliminar una franja");
        return listaFranjaHorarias.removeIf(c -> Objects.equals(c.getId(), id));
    }

    private void cargarfranjas() {
        this.listaFranjaHorarias.add(new FranjaHorariaEntity(1L, 1L, 1L, "LUNES", "09:00", "11:00"));
        this.listaFranjaHorarias.add(new FranjaHorariaEntity(2L, 1L, 1L, "MARTES", "14:00", "16:00"));
        this.listaFranjaHorarias.add(new FranjaHorariaEntity(3L, 2L, 2L, "JUEVES", "07:00", "09:00"));
        this.listaFranjaHorarias.add(new FranjaHorariaEntity(4L, 2L, 2L, "VIERNES", "16:00", "18:00"));
    }
}
