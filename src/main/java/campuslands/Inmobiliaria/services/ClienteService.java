package campuslands.Inmobiliaria.services;

import java.util.List;

import campuslands.Inmobiliaria.repositories.entities.ClienteEntity;

public interface ClienteService {
    
    List<ClienteEntity>findAll();

    ClienteEntity findById(Long id);

    ClienteEntity save(ClienteEntity cliente);

    ClienteEntity update(Long id, ClienteEntity cliente);

    void delete(Long id);


}
