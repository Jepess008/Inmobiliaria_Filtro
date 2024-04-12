package campuslands.Inmobiliaria.services;

import java.util.List;


import campuslands.Inmobiliaria.repositories.entities.PropietarioEntity;

public interface PropietarioService {
    

    List<PropietarioEntity>findAll();

    PropietarioEntity findById(Long id);

    
}
