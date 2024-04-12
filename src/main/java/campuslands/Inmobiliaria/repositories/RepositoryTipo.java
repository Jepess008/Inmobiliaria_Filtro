package campuslands.Inmobiliaria.repositories;

import org.springframework.data.repository.CrudRepository;

import campuslands.Inmobiliaria.repositories.entities.TipoEntity;

public interface RepositoryTipo extends CrudRepository<TipoEntity,Long> {
    
}
