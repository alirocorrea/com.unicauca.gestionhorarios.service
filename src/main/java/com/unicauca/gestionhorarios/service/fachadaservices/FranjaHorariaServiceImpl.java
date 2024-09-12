package com.unicauca.gestionhorarios.service.fachadaservices;

import com.unicauca.gestionhorarios.service.capaaccesodatos.models.FranjaHorariaEntity;
import com.unicauca.gestionhorarios.service.capaaccesodatos.repositories.FranjaHorariaRepository;
import com.unicauca.gestionhorarios.service.fachadaservices.dto.FranjaHorariaDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FranjaHorariaServiceImpl implements FranjaHorariaService {

    private final FranjaHorariaRepository franjaHorariaRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<FranjaHorariaDTO> findAll() {
        final List<FranjaHorariaEntity> franjaHorariaEntities = this.franjaHorariaRepository.findAll();
        return this.modelMapper.map(franjaHorariaEntities, new TypeToken<List<FranjaHorariaDTO>>() { }.getType());
    }

    @Override
    public FranjaHorariaDTO findById(final Long id) {
        final FranjaHorariaEntity objFranjaHorariaEntity = this.franjaHorariaRepository.findById(id);
        if (objFranjaHorariaEntity == null) {
            System.out.println("ID Franja horaria no encontrado");
            return null;
        }
        return this.modelMapper.map(objFranjaHorariaEntity, FranjaHorariaDTO.class);
    }

    @Override
    public FranjaHorariaDTO save(final FranjaHorariaDTO cliente) {
        final FranjaHorariaEntity FranjaHorariaEntity = this.modelMapper.map(cliente, FranjaHorariaEntity.class);
        final FranjaHorariaEntity objFranjaHorariaEntity = this.franjaHorariaRepository.save(FranjaHorariaEntity);
        return this.modelMapper.map(objFranjaHorariaEntity, FranjaHorariaDTO.class);
    }

    @Override
    public FranjaHorariaDTO update(final Long id, final FranjaHorariaDTO cliente) {
        final FranjaHorariaEntity franjaHorariaExistente = franjaHorariaRepository.findById(id);
        if (franjaHorariaExistente == null) {
            System.out.println("ID Franja horaria no encontrado");
            return null;
        }
        final FranjaHorariaEntity franjaHorariaEntity = this.modelMapper.map(cliente, FranjaHorariaEntity.class);
        final FranjaHorariaEntity franjaHorariaEntityActualizado = this.franjaHorariaRepository.update(id, franjaHorariaEntity);
        return this.modelMapper.map(franjaHorariaEntityActualizado, FranjaHorariaDTO.class);
    }

    @Override
    public boolean delete(final Long id) {
        final FranjaHorariaEntity franjaHorariaExistente = franjaHorariaRepository.findById(id);
        if (franjaHorariaExistente == null) {
            System.out.println("ID Franja horaria no encontrado");
            return false;
        }
        return this.franjaHorariaRepository.delete(id);
    }
}
