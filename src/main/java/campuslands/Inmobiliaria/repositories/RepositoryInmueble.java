package campuslands.Inmobiliaria.repositories;

import org.springframework.data.repository.CrudRepository;

import campuslands.Inmobiliaria.repositories.entities.InmuebleEntity;

public interface RepositoryInmueble extends CrudRepository<InmuebleEntity,Long>{
    
    
}
