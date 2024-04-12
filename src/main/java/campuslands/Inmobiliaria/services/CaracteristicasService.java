package campuslands.Inmobiliaria.services;

import java.util.List;

import campuslands.Inmobiliaria.repositories.entities.CaracteristicasEntity;


public interface CaracteristicasService {
    
    List<CaracteristicasEntity>findAll();

    CaracteristicasEntity findById(Long id);

    CaracteristicasEntity save(CaracteristicasEntity caracteristicas);
}
