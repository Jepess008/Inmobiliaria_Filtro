package campuslands.Inmobiliaria.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import campuslands.Inmobiliaria.repositories.RepositoryZona;
import campuslands.Inmobiliaria.repositories.entities.ZonaEntity;
import campuslands.Inmobiliaria.services.ZonaService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service

public class ZonaServiceImpl implements ZonaService{

    private RepositoryZona repositoryZona;


    @Override
    @Transactional(readOnly = true)
    public List<ZonaEntity> findAll() {
        return (List<ZonaEntity>) repositoryZona.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public ZonaEntity findById(Long id) {
        return repositoryZona.findById(id).orElse(null);
    }
    
}
