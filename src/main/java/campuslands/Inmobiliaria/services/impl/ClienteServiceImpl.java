package campuslands.Inmobiliaria.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import campuslands.Inmobiliaria.repositories.RepositoryCliente;
import campuslands.Inmobiliaria.repositories.entities.ClienteEntity;
import campuslands.Inmobiliaria.services.ClienteService;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class ClienteServiceImpl implements ClienteService{

    private RepositoryCliente repositoryCliente;

    @Override
    @Transactional(readOnly = true)
    public List<ClienteEntity> findAll() {
        return (List<ClienteEntity>) repositoryCliente.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public ClienteEntity findById(Long id) {
        return repositoryCliente.findById(id).orElse(null);
    }

    @Override
    public ClienteEntity save(ClienteEntity cliente) {
        return repositoryCliente.save(cliente);
    }

    @Override
    public ClienteEntity update(Long id, ClienteEntity cliente) {
        Optional<ClienteEntity> clienteCurrentOptional =repositoryCliente.findById(id);

        if(clienteCurrentOptional.isPresent()){
            ClienteEntity clienteCurrent=clienteCurrentOptional.get();
            clienteCurrent.setNombre(cliente.getNombre());
            clienteCurrent.setApellido(cliente.getApellido());
            clienteCurrent.setTelefono(cliente.getTelefono());
            repositoryCliente.save(clienteCurrent);
            return clienteCurrent;
        }

        return null;
    }

    @Override
    public void delete(Long id) {
        Optional<ClienteEntity> clienteOptional= repositoryCliente.findById(id);
        if (clienteOptional.isPresent()) {
                repositoryCliente.delete(clienteOptional.get());
        }
    }
    
}
