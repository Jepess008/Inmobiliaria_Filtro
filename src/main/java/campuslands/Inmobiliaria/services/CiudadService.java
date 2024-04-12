package campuslands.Inmobiliaria.services;

import java.util.List;

import campuslands.Inmobiliaria.repositories.entities.CiudadEntity;

public interface CiudadService {
    
    List<CiudadEntity>findAll();

    CiudadEntity findById(Long id);

   
}
