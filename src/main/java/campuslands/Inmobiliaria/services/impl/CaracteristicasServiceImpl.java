package campuslands.Inmobiliaria.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import campuslands.Inmobiliaria.repositories.RepositoryCaracteristicas;
import campuslands.Inmobiliaria.repositories.entities.CaracteristicasEntity;
import campuslands.Inmobiliaria.services.CaracteristicasService;
import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class CaracteristicasServiceImpl implements CaracteristicasService {


    private RepositoryCaracteristicas repositoryCaracteristicas;

    @Transactional(readOnly = true)
    @Override
    public List<CaracteristicasEntity> findAll() {
        return (List<CaracteristicasEntity>) repositoryCaracteristicas.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public CaracteristicasEntity findById(Long id) {
        return repositoryCaracteristicas.findById(id).orElse(null);
    }

    @Override
    public CaracteristicasEntity save(CaracteristicasEntity caracteristicas) {
        return repositoryCaracteristicas.save(caracteristicas);
    }
    
}
