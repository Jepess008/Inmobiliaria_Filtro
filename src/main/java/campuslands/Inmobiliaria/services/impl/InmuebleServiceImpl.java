package campuslands.Inmobiliaria.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import campuslands.Inmobiliaria.config.InmuebleDTOConverter;
import campuslands.Inmobiliaria.dto.InmuebleDTO;
import campuslands.Inmobiliaria.repositories.RepositoryInmueble;
import campuslands.Inmobiliaria.repositories.RepositoryOficina;
import campuslands.Inmobiliaria.repositories.RepositoryPropietario;
import campuslands.Inmobiliaria.repositories.RepositoryTipo;
import campuslands.Inmobiliaria.repositories.RepositoryZona;
import campuslands.Inmobiliaria.repositories.entities.InmuebleEntity;
import campuslands.Inmobiliaria.repositories.entities.OficinaEntity;
import campuslands.Inmobiliaria.repositories.entities.PropietarioEntity;
import campuslands.Inmobiliaria.repositories.entities.TipoEntity;
import campuslands.Inmobiliaria.repositories.entities.ZonaEntity;
import campuslands.Inmobiliaria.services.InmuebleService;
import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor

public class InmuebleServiceImpl implements InmuebleService {


    private RepositoryInmueble repositoryInmueble;
    private RepositoryPropietario repositoryPropietario;
    private RepositoryZona repositoryZona;
    private RepositoryTipo repositoryTipo;
    private RepositoryOficina repositoryOficina;
    

    private InmuebleDTOConverter converter;

    

    @Override
    @Transactional(readOnly = true)
    public List<InmuebleDTO> findAll() {
        List<InmuebleEntity> inmuebles= (List<InmuebleEntity>)repositoryInmueble.findAll();
        return inmuebles.stream()
                                .map(inmueble -> converter.convertInmuebleDTO(inmueble))
                                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public InmuebleDTO findById(Long id) {
        InmuebleEntity inmueble= repositoryInmueble.findById(id).orElse(null);
        return converter.convertInmuebleDTO(inmueble);
    }

    @Override
    public InmuebleDTO findByRef(String ref) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByRef'");
    }

    
    @Override
    @Transactional
    public InmuebleDTO save(InmuebleDTO inmueble) {
        Optional<PropietarioEntity> propietarioOptional = repositoryPropietario.findById(inmueble.getId_propietario());
        Optional<ZonaEntity> zonaOptional = repositoryZona.findById(inmueble.getId_zona());
        Optional<OficinaEntity> oficinaOptional = repositoryOficina.findById(inmueble.getId_oficina());
        Optional<TipoEntity> tipoOptional = repositoryTipo.findById(inmueble.getId_tipo());



        if(propietarioOptional.isPresent() && zonaOptional.isPresent() && oficinaOptional.isPresent() && tipoOptional.isPresent() ) {
            InmuebleEntity inmuebleEntity= converter.convertInmueble(inmueble);
            inmuebleEntity.setPropietario(propietarioOptional.get());
            inmuebleEntity.setZona(zonaOptional.get());
            inmuebleEntity.setOficina(oficinaOptional.get());
            inmuebleEntity.setTipo(tipoOptional.get());
            repositoryInmueble.save(inmuebleEntity);
            return converter.convertInmuebleDTO(inmuebleEntity);
        }

       return null;
    }

    
    @Override
    @Transactional
    public InmuebleEntity update(Long id, InmuebleEntity inmueble) {
        Optional<InmuebleEntity> inmuebleCurrentOptional=repositoryInmueble.findById(id);

        if(inmuebleCurrentOptional.isPresent()){
            InmuebleEntity inmuebleCurrent=inmuebleCurrentOptional.get();
            inmuebleCurrent.setLlaves(inmueble.getLlaves());
            inmuebleCurrent.setSuperficie(inmueble.getSuperficie());
            inmuebleCurrent.setDisponible(inmueble.getDisponible());
            inmuebleCurrent.setPrecio(inmueble.getPrecio());
            repositoryInmueble.save(inmuebleCurrent);
            return inmuebleCurrent;
        }

        return null;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Optional<InmuebleEntity> inmuebleOptional=repositoryInmueble.findById(id);
        if(inmuebleOptional.isPresent()){
            repositoryInmueble.delete(inmuebleOptional.get());
        }
    }
    
}
