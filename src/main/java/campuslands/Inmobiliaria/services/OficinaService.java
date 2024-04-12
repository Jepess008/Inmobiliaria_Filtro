package campuslands.Inmobiliaria.services;

import java.util.List;

import campuslands.Inmobiliaria.repositories.entities.OficinaEntity;

public interface OficinaService {
    
    List<OficinaEntity>findAll();

    OficinaEntity findById(Long id);
}
