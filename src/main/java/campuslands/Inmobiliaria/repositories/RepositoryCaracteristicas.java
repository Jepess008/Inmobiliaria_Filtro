package campuslands.Inmobiliaria.repositories;

import org.springframework.data.repository.CrudRepository;

import campuslands.Inmobiliaria.repositories.entities.CaracteristicasEntity;

public interface RepositoryCaracteristicas extends CrudRepository<CaracteristicasEntity,Long> {
    
}
