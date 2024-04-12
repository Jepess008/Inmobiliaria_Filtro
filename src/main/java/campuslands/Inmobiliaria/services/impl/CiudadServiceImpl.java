package campuslands.Inmobiliaria.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import campuslands.Inmobiliaria.repositories.RepositoryCiudad;
import campuslands.Inmobiliaria.repositories.entities.CiudadEntity;
import campuslands.Inmobiliaria.services.CiudadService;
import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor

public class CiudadServiceImpl implements CiudadService{


    private RepositoryCiudad repositoryCiudad;


    @Transactional(readOnly = true)
    @Override
    public List<CiudadEntity> findAll() {
        return (List<CiudadEntity>) repositoryCiudad.findAll();
    }

    
    @Override
    @Transactional(readOnly = true)
    public CiudadEntity findById(Long id) {
       return repositoryCiudad.findById(id).orElse(null);
    }

  
    
}
