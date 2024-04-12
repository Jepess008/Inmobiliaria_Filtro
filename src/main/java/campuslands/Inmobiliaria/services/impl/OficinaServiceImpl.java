package campuslands.Inmobiliaria.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import campuslands.Inmobiliaria.repositories.RepositoryOficina;
import campuslands.Inmobiliaria.repositories.entities.OficinaEntity;
import campuslands.Inmobiliaria.services.OficinaService;
import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor

public class OficinaServiceImpl implements OficinaService{


    private RepositoryOficina repositoryOficina;

    @Override
    @Transactional(readOnly = true)
    public List<OficinaEntity> findAll() {
       return (List<OficinaEntity>) repositoryOficina.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public OficinaEntity findById(Long id) {
        return repositoryOficina.findById(id).orElse(null);
    }
    
}
