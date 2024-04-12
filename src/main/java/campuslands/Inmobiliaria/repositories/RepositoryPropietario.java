package campuslands.Inmobiliaria.repositories;

import org.springframework.data.repository.CrudRepository;

import campuslands.Inmobiliaria.repositories.entities.PropietarioEntity;

public interface RepositoryPropietario extends CrudRepository<PropietarioEntity,Long> {
    
}
