package campuslands.Inmobiliaria.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import campuslands.Inmobiliaria.dto.InmuebleDTO;
import campuslands.Inmobiliaria.repositories.entities.InmuebleEntity;

@Component
public class InmuebleDTOConverter {
    
    private ModelMapper dbm;

    public InmuebleDTOConverter(ModelMapper modelMapper){
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        this.dbm=modelMapper;
    }

    public InmuebleDTO convertInmuebleDTO(InmuebleEntity inmueble){
        
        InmuebleDTO inmuebleDTO = dbm.map(inmueble, InmuebleDTO.class);
        inmuebleDTO.setId_zona(inmueble.getZona().getId());
        inmuebleDTO.setZona(inmueble.getZona().getNombre());
        inmuebleDTO.setId_propietario(inmueble.getPropietario().getId());
        inmuebleDTO.setNombre_propietario(inmueble.getPropietario().getNombre() + " " + inmueble.getPropietario().getApellido());
        inmuebleDTO.setId_oficina(inmueble.getOficina().getId());
        inmuebleDTO.setOficina(inmueble.getOficina().getNombre());
        inmuebleDTO.setCiudad(inmueble.getOficina().getCiudad().getNombre());
        inmuebleDTO.setId_tipo(inmueble.getTipo().getId());
        inmuebleDTO.setTipo(inmueble.getTipo().getNombre_tipo());
        inmuebleDTO.setTamaño_parcela(inmueble.getTipo().getCaracteristicas().getTamaño_parcela());
        inmuebleDTO.setUrbanizacion(inmueble.getTipo().getCaracteristicas().getUrbanizacion());
        inmuebleDTO.setHabitaciones(inmueble.getTipo().getCaracteristicas().getHabitaciones());
        inmuebleDTO.setBaños(inmueble.getTipo().getCaracteristicas().getBaños());
        inmuebleDTO.setAseos(inmueble.getTipo().getCaracteristicas().getAseos());
        inmuebleDTO.setCocinas(inmueble.getTipo().getCaracteristicas().getCocinas());
        inmuebleDTO.setEspecificas(inmueble.getTipo().getCaracteristicas().getEspecificas());
        inmuebleDTO.setNum_puertas(inmueble.getTipo().getCaracteristicas().getNum_puertas());
        inmuebleDTO.setDiagano(inmueble.getTipo().getCaracteristicas().getDiagano());
        inmuebleDTO.setAcondicionado(inmueble.getTipo().getCaracteristicas().getAcondicionado());
        return inmuebleDTO;


    }

    public InmuebleEntity convertInmueble(InmuebleDTO inmuebleDTO){

        InmuebleEntity inmueble= dbm.map(inmuebleDTO, InmuebleEntity.class);
        return inmueble;
    }


}
