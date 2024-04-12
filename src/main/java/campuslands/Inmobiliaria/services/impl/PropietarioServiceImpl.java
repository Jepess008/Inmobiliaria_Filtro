package campuslands.Inmobiliaria.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import campuslands.Inmobiliaria.repositories.RepositoryPropietario;
import campuslands.Inmobiliaria.repositories.entities.PropietarioEntity;
import campuslands.Inmobiliaria.services.PropietarioService;

import lombok.AllArgsConstructor;



@Service
@AllArgsConstructor
public class PropietarioServiceImpl implements PropietarioService{


    private RepositoryPropietario repositoryPropietario;

    @Transactional(readOnly = true)
    @Override
    public List<PropietarioEntity> findAll() {
        return (List<PropietarioEntity>) repositoryPropietario.findAll();
    }

    
    @Override
    @Transactional(readOnly = true)
    public PropietarioEntity findById(Long id) {
        return repositoryPropietario.findById(id).orElse(null);
    }

  
    
}
