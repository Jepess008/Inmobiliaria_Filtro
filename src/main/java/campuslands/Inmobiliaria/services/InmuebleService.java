package campuslands.Inmobiliaria.services;

import java.util.List;

import campuslands.Inmobiliaria.dto.InmuebleDTO;
import campuslands.Inmobiliaria.repositories.entities.InmuebleEntity;

public interface InmuebleService {
    
     List<InmuebleDTO> findAll();

    InmuebleDTO findById(Long id);

    InmuebleDTO findByRef(String ref);

    InmuebleDTO save(InmuebleDTO inmueble);

    InmuebleEntity update(Long id, InmuebleEntity inmueble);

    void delete(Long id);
}
