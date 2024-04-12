package campuslands.Inmobiliaria.repositories;

import org.springframework.data.repository.CrudRepository;

import campuslands.Inmobiliaria.repositories.entities.ClienteEntity;

public interface RepositoryCliente extends CrudRepository<ClienteEntity,Long> {
    
}
