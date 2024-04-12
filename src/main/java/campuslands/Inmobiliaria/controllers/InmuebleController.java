package campuslands.Inmobiliaria.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import campuslands.Inmobiliaria.dto.InmuebleDTO;
import campuslands.Inmobiliaria.repositories.entities.InmuebleEntity;
import campuslands.Inmobiliaria.services.InmuebleService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/inmuebles")
@AllArgsConstructor
public class InmuebleController {
    
    private InmuebleService inmuebleService;

    @GetMapping("/")
    @JsonView(InmuebleDTO.class)
    public List<InmuebleDTO> findAll(){
        return inmuebleService.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Map<String,Object>> findAllById(@PathVariable Long id){
        
        Map<String,Object> response=new HashMap<>();

        InmuebleDTO inmueble= inmuebleService.findById(id);

        if(inmueble!=null){
            response.put("inmueble", inmueble);
            return new ResponseEntity<>(response,HttpStatus.OK);
        }else{
            response.put("mensaje", new String("No existe ningun Inmueble con ese id"));
            return new ResponseEntity<>(response,HttpStatus.NO_CONTENT);
        }
    
    }

    @PostMapping("/")
    public ResponseEntity<Map<String, Object>> save(@Valid @RequestBody InmuebleDTO inmueble, BindingResult result) {

        InmuebleDTO inmuebleNew = null;

        Map<String, Object> response = new HashMap<>();

        if (result.hasErrors()) {
            List<String> errors = result.getFieldErrors()
                    .stream()
                    .map(err -> "El campo " + err.getField() + " " + err.getDefaultMessage())
                    .collect(Collectors.toList());
            response.put("errors", errors);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        try {

            inmuebleNew = inmuebleService.save(inmueble);

        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar el insert en la base de datos");
            response.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);

        }

        response.put("mensaje", "El Inmueble ha sido creado con éxito");
        response.put("inmueble", inmuebleNew);

        return new ResponseEntity<>(response, HttpStatus.OK);

    }


    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> update(@Valid @RequestBody InmuebleEntity inmueble, BindingResult result,
            @PathVariable Long id) {

        InmuebleEntity inmuebleUpdate = null;

        Map<String, Object> response = new HashMap<>();

        if (result.hasErrors()) {
            List<String> errors = result.getFieldErrors()
                    .stream()
                    .map(err -> "El campo " + err.getField() + " " + err.getDefaultMessage())
                    .collect(Collectors.toList());
            response.put("errors", errors);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        try {

            inmuebleUpdate = inmuebleService.update(id, inmueble);

        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar el upate en la base de datos");
            response.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);

        }

        response.put("mensaje", "El Inmueble ha sido actualizado con éxito");
        response.put("inmueble", inmuebleUpdate);

        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable Long id) {

        Map<String, Object> response = new HashMap<>();
        try {
            inmuebleService.delete(id);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar el insert en la base de datos");
            response.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El Inmueble se ha elimando con éxito");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }



}
