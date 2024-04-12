package campuslands.Inmobiliaria.services;

import java.util.List;

import campuslands.Inmobiliaria.repositories.entities.ZonaEntity;

public interface ZonaService {
    
    List<ZonaEntity>findAll();

    ZonaEntity findById(Long id);
}
